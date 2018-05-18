package edu.db.myBrute.data;

import edu.db.myBrute.domain.GameUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private Connection connection;
    private static UserRepo userRepo = new UserRepo();

    private UserRepo() {
        // Create a variable for the connection string.
        // TODO: Change username & password
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;user=UserName;password=*****";

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println("ERROR CONNECTING TO DATABASE");
        }
        finally {
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }

    public static UserRepo getInstance() {
        return userRepo;
    }

    public GameUser signUp(String username, String password) {
        GameUser gameUser = new GameUser();
        return gameUser;
    }

    public GameUser login(String username, String password) {
        GameUser gameUser = new GameUser();
        return gameUser;
    }

    public List<GameUser> getOpponents() {
        List<GameUser> opponents = new ArrayList<GameUser>();

        return opponents;
    }

    public GameUser currentUser() {
        GameUser user = null;

        return user;
    }
}
