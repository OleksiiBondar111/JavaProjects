package com.luxoft.userstore.entityDAO;

/**
 * Created by OBondar on 31.01.2019.
 */

import com.luxoft.userstore.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:sqlite:F:\\JavaProjects\\GIT\\JavaProjects\\UserStore\\DB\\test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int save(User user) {
        int status = 0;
        String sqlQuery = "INSERT INTO users(first_name,last_name,salary,date_of_birth) VALUES (?,?,?,?)";
        try {
            Connection connection = UserDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.setDate(4, user.getDateOfBirth());

            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(User user) {
        int status = 0;
        String sqlQuery = "UPDATE users SET first_name=?,last_name=?,salary=?,date_of_birth=? WHERE id=?";
        try {
            Connection connection = UserDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.setDate(4, user.getDateOfBirth());
            preparedStatement.setInt(5, user.getId());

            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        String sqlQuery = "DELETE FROM users WHERE id=?";
        try {
            Connection connection = UserDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static User getUserById(int id) {
        User user = new User();
        String sqlQuery = "SELECT * FROM users WHERE id=?";
        try {
            Connection connection = UserDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setSalary(resultSet.getDouble(4));
                user.setDateOfBirth(resultSet.getDate(5));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users";
        try {
            Connection connection = UserDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setSalary(resultSet.getDouble(4));
                user.setDateOfBirth(resultSet.getDate(5));
                list.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}