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
        // TODO: Change username & password
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=my_brute";

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

            if (resultSet.next()) {
                user.setHealthPoint(resultSet.getInt("Health_Point"));
                user.setLeftFights(resultSet.getInt("Left_fights"));
                user.getHero().setStrength(resultSet.getInt("Strength"));
                user.getHero().setAgility(resultSet.getInt("Agility"));
                user.getHero().setSpeed(resultSet.getInt("Speed"));
                user.getHero().setHeroType(resultSet.getInt("Hero_Type"));
            }

            this.gameUser = user;
        } else {
            throw new IllegalArgumentException("Wrong username or password");
        }
    }

    public void logout() {
        this.gameUser = null;
    }

    public List<GameUser> getOpponentsFor(GameUser user) {
        List<GameUser> opponents = new ArrayList<GameUser>();

        return opponents;
    }

    public GameUser currentUser() {
        return this.gameUser;
    }

    public GameUser loadUserByUsername(String username) {
        GameUser user = new GameUser();

        return user;
    }
}
