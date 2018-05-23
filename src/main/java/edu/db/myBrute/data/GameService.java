package edu.db.myBrute.data;

import edu.db.myBrute.domain.GameUser;
import edu.db.myBrute.domain.Weapon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Connection connection;
    private String currentUsername = null;
    private static GameService gameService = new GameService();

    private GameService() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=my_brute;integratedSecurity=true";

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR CONNECTING DATABASE");
        }
    }

    public static GameService getInstance() {
        return gameService;
    }

    public void signUp(String username, String password) throws SQLException {
        String query = "EXEC SignUP ?, ?";
        CallableStatement callableStatement = connection.prepareCall(query);

        callableStatement.setString(1, username);
        callableStatement.setString(2, password);

        callableStatement.execute();
    }

    public void login(String username, String password) throws SQLException {
        String query = "SELECT * FROM Login (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            this.currentUsername = resultSet.getString("Username");
        } else {
            throw new IllegalArgumentException("Wrong username or password");
        }
    }

    public void logout() {
        this.currentUsername = null;
    }

    public List<GameUser> getOpponentsFor(GameUser user) throws SQLException {
        List<GameUser> opponents = new ArrayList<>();

        String query = "SELECT * FROM ShowAvaliableOpponents (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getUsername());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            GameUser opponent = new GameUser();

            opponent.setUsername(resultSet.getString("Username"));
            opponent.setExperience(resultSet.getInt("Experience"));
            opponent.setLevelId(resultSet.getInt("Level_Id"));
            opponent.setHealthPoint(resultSet.getInt("Health_Point"));
            opponent.setLeftFights(resultSet.getInt("Left_fights"));

            opponent.getHero().setStrength(resultSet.getInt("Strength"));
            opponent.getHero().setAgility(resultSet.getInt("Agility"));
            opponent.getHero().setSpeed(resultSet.getInt("Speed"));
            opponent.getHero().setHeroType(resultSet.getInt("Hero_Type"));

            opponent.setWeapons(getWeaponsFor(opponent.getUsername()));

            opponents.add(opponent);
        }

        return opponents;
    }

    public GameUser currentUser() throws SQLException {
        return loadUserByUsername(this.currentUsername);
    }

    public GameUser loadUserByUsername(String username) throws SQLException {
        GameUser user = new GameUser();
        String query = "SELECT * FROM dbo.Game_User WHERE Username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user.setUsername(resultSet.getString("Username"));
            user.setExperience(resultSet.getInt("Experience"));
            user.setLevelId(resultSet.getInt("Level_Id"));

            user = getHeroInfoFor(user);

            user.setWeapons(getWeaponsFor(username));

            return user;
        } else {
            return null;
        }
    }

    private GameUser getHeroInfoFor(GameUser user) throws SQLException {
        String sql = "SELECT * FROM dbo.hero_info WHERE Username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user.setHealthPoint(resultSet.getInt("Health_Point"));
            user.setLeftFights(resultSet.getInt("Left_fights"));
            user.getHero().setStrength(resultSet.getInt("Strength"));
            user.getHero().setAgility(resultSet.getInt("Agility"));
            user.getHero().setSpeed(resultSet.getInt("Speed"));
            user.getHero().setHeroType(resultSet.getInt("Hero_Type"));
        }

        return user;
    }

    private List<Weapon> getWeaponsFor(String username) throws SQLException {
        List<Weapon> weapons = new ArrayList<>();

        String sql = "SELECT * FROM BruteWeapons (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            weapons.add(getWeaponInfo(resultSet.getInt("Weapon_Id")));
        }

        return weapons;
    }

    private Weapon getWeaponInfo(int weaponId) throws SQLException {
        Weapon weapon = new Weapon();

        String sql = "SELECT * FROM dbo.Weapon WHERE Weapon_Id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, weaponId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            weapon.setWeaponId(weaponId);
            weapon.setAgility(resultSet.getInt("Agility"));
            weapon.setSpeed(resultSet.getInt("Speed"));
            weapon.setStrength(resultSet.getInt("Strength"));
            weapon.setChance(resultSet.getInt("Chance"));
            weapon.setLevelId(resultSet.getInt("Level_Id"));
        } else {
            throw new IllegalArgumentException("Invalid Weapon Id");
        }

        return weapon;
    }

    public void attackTo(String opponentUsername) throws SQLException {
        String query = "EXEC Attacking ?, ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, this.currentUsername);
        preparedStatement.setString(2, opponentUsername);

        preparedStatement.executeQuery();
    }

    public GameUser getWinner() throws SQLException {
        GameUser winner = new GameUser();
        String query = "SELECT TOP 1 Winner FROM dbo.attack ORDER BY Attack_Id DESC";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            winner.setUsername(resultSet.getString("Username"));
            winner.setExperience(resultSet.getInt("Experience"));
            winner.setExperience(resultSet.getInt("Level_Id"));

            winner = getHeroInfoFor(winner);

            winner.setWeapons(getWeaponsFor(winner.getUsername()));
        }

        return winner;
    }
}
