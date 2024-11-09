package com.julian.employeemanagementapp.database;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class DBConnector {

    private final String dbURL;
    private final String dbUsername;
    private final String dbPassword;
    private Connection connection;

    public String getDbURL() { return dbURL;}
    public String getDbUsername() { return dbUsername;}
    public String getDbPassword() { return dbPassword;}

    private DBConnector()
    {
        Dotenv dotenv = Dotenv.load();
        dbURL = dotenv.get("URL");
        dbUsername = dotenv.get("DB_USERNAME");
        dbPassword = dotenv.get("PASSWORD");
        connection = null;
    }

    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.getLocalizedMessage();
            }
        }
    }

    private static DBConnector instance;

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

}
