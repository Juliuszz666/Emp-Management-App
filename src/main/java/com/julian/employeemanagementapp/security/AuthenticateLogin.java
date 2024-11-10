package com.julian.employeemanagementapp.security;

import com.julian.employeemanagementapp.database.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthenticateLogin {

    private static final String DB_ADMIN = "DBAdmins";
    private static final String DB_USER = "DatabaseUsers";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ADMIN_NAME_COLUMN = "AdminName";
    private static final String USER_LOGIN_COLUMN = "userLogin";

    private static boolean authFromDB(LoginData binderBean, String DBTable) {
        String username = binderBean.getUsername();
        String password = binderBean.getPassword();
        String usernameColumn = DBTable.equals(DB_ADMIN) ? ADMIN_NAME_COLUMN : USER_LOGIN_COLUMN;
        String query = "SELECT "+ PASSWORD_COLUMN + " FROM " + DBTable + " WHERE " + usernameColumn + " = ?";

        try (Connection connection = DBConnector.getInstance().connect();
             PreparedStatement queryStatement = connection.prepareStatement(query)) {

            queryStatement.setString(1, username);
            ResultSet resultSet = queryStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString(PASSWORD_COLUMN);
                return PasswordHashing.verifyPassword(password, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean authenticate(LoginData binderBean) {
        return authFromDB(binderBean, DB_ADMIN) || authFromDB(binderBean, DB_USER);
    }
}
