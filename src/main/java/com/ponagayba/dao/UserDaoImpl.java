package com.ponagayba.dao;

import com.ponagayba.factory.ConnectionFactory;
import com.ponagayba.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(User user) throws SQLException {
        try(
            Connection connection = ConnectionFactory.getConnection()
        ) {
           String query = "SELECT * FROM users WHERE username=? AND password=?";
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, user.getUsername());
           preparedStatement.setString(2, user.getPassword());
           ResultSet resultSet = preparedStatement.executeQuery();
           User result = null;
           if (resultSet.next()) {
               result = new User();
               result.setId(resultSet.getLong("id"));
               result.setUsername(resultSet.getString("username"));
               result.setPassword(resultSet.getString("password"));
           }
           return result;
        }
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        try(
            Connection connection = ConnectionFactory.getConnection()
        ) {
            String query = "SELECT * FROM users WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public boolean create(User user) throws SQLException {
        try(
                Connection connection = ConnectionFactory.getConnection()
        ) {
            String query = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
            return true;
        }
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User findById(User user) {
        return null;
    }
}
