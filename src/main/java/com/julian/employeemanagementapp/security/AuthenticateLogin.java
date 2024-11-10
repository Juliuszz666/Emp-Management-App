package com.julian.employeemanagementapp.security;

import com.julian.employeemanagementapp.database.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;


public class AuthenticateLogin {

    private static final String DB_ADMIN = "DBAdmins";
    private static final String DB_USER = "DatabaseUsers";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ADMIN_NAME_COLUMN = "AdminName";
    private static final String USER_LOGIN_COLUMN = "userLogin";

    private static boolean authFromDB(LoginData loginCredentials, String DBTable) {
        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();
        String usernameColumn = DBTable.equals(DB_ADMIN) ? ADMIN_NAME_COLUMN : USER_LOGIN_COLUMN;
        String query = MessageFormat.format("SELECT {0} FROM {1} WHERE {2} = ?", PASSWORD_COLUMN, DBTable, usernameColumn);

        try (Connection connection = DBConnector.getInstance().connect();
             PreparedStatement queryStatement = connection.prepareStatement(query)) {

            queryStatement.setString(1, username);
            ResultSet resultSet = queryStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString(PASSWORD_COLUMN);
                return PasswordHashing.verifyPassword(password, dbPassword);
            }
        } catch (SQLException e) {
           System.err.println(MessageFormat.format("Error: {0}", e.getMessage()));
        }
        return false;
    }

    public static boolean authenticate(LoginData loginCredentials) {
        return authFromDB(loginCredentials, DB_ADMIN) || authFromDB(loginCredentials, DB_USER);
    }
}
