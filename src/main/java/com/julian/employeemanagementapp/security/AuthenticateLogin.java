package com.julian.employeemanagementapp.security;

import com.julian.employeemanagementapp.database.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthenticateLogin {

    private static boolean authFromDB(LoginData binderBean, String DBTable) {
        String username = binderBean.getUsername();
        String password = binderBean.getPassword();
        String usernameColumn = DBTable.equals("DBAdmins") ? "AdminName" : "userLogin";
        String query = "SELECT password FROM " + DBTable + " WHERE " + usernameColumn + " = ?";


        try (Connection connection = DBConnector.getInstance().connect();
             PreparedStatement queryStatement = connection.prepareStatement(query)) {

            queryStatement.setString(1, username);
            ResultSet resultSet = queryStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                return PasswordHashing.verifyPassword(password, dbPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static boolean authenticate(LoginData binderBean) {
        return authFromDB(binderBean, "DBAdmins") || authFromDB(binderBean, "DatabaseUsers");
    }
}
