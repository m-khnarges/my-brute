package edu.db.myBrute.data;

import edu.db.myBrute.domain.GameUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private Connection connection;
    private GameUser gameUser = null;
    private static UserRepo userRepo = new UserRepo();

    private UserRepo() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=my_brute";

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println("ERROR CONNECTING TO DATABASE");
        } finally {
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
                System.out.println("CONNECTION CLOSE EXCEPTION");
            }
        }
    }

    public static UserRepo getInstance() {
        return userRepo;
    }

    public void signUp(String username, String password) throws SQLException {
        String query = "EXEC SignUP ?, ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
    }

    public void login(String username, String password) throws SQLException {
        GameUser user = new GameUser();
        String query = "EXEC Login ?, ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user.setUsername(resultSet.getString("Username"));
            user.setExperience(resultSet.getInt("Experience"));
            user.setExperience(resultSet.getInt("Level_Id"));

            query = "SELECT * FROM dbo.hero_info WHERE Username = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            user = getHeroInfo(user, resultSet);

            this.gameUser = user;
        } else {
            throw new IllegalArgumentException("Wrong username or password");
        }
    }

    public void logout() {
        this.gameUser = null;
    }

    public List<GameUser> getOpponents() throws SQLException {
        List<GameUser> opponents = new ArrayList<GameUser>();

        String query = "SELECT * FROM dbo.opponents WHERE Level_Id != ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, gameUser.getLevelId());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            GameUser opponent = new GameUser();

            opponent.setUsername(resultSet.getString("Username"));
            opponent.setExperience(resultSet.getInt("Experience"));
            opponent.setExperience(resultSet.getInt("Level_Id"));

            opponent.setHealthPoint(resultSet.getInt("Health_Point"));
            opponent.setLeftFights(resultSet.getInt("Left_fights"));
            opponent.getHero().setStrength(resultSet.getInt("Strength"));
            opponent.getHero().setAgility(resultSet.getInt("Agility"));
            opponent.getHero().setSpeed(resultSet.getInt("Speed"));
            opponent.getHero().setHeroType(resultSet.getInt("Hero_Type"));

            opponents.add(opponent);
        }

        return opponents;
    }

    public GameUser currentUser() {
        return this.gameUser;
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
            user.setExperience(resultSet.getInt("Level_Id"));

            query = "SELECT * FROM dbo.hero_info WHERE Username = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            user = getHeroInfo(user, resultSet);

        }

        return user;
    }

    private GameUser getHeroInfo(GameUser user, ResultSet resultSet) throws SQLException {
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

    public void attack(String myUsername, String opponentUsername) throws SQLException {
        String query = "EXEC Attacking ?, ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, myUsername);
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

            query = "SELECT * FROM dbo.hero_info WHERE Username = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, winner.getUsername());

            resultSet = preparedStatement.executeQuery();

            winner = getHeroInfo(winner, resultSet);

        }

        return winner;
    }
}
