package com.ponagayba.dao;

import com.ponagayba.model.Role;
import com.ponagayba.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User getUser(User user) throws SQLException {
       String query =
               "SELECT id, email, token " +
               "FROM users " +
               "WHERE username=? AND password=?";
       PreparedStatement preparedStatement = connection.prepareStatement(query);
       preparedStatement.setString(1, user.getUsername());
       preparedStatement.setString(2, user.getPassword());
       ResultSet resultSet = preparedStatement.executeQuery();
       User result = null;
       if (resultSet.next()) {
           result = new User();
           result.setId(resultSet.getInt("id"));
           result.setEmail(resultSet.getString("email"));
           result.setToken(resultSet.getString("token"));
           result.setUsername(user.getUsername());
           result.setPassword(user.getPassword());
       }
       return result;
    }

    @Override
    public List<User> getAll() throws SQLException {
        String query =
                "SELECT id, username, password, email, token " +
                "FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<User> result = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("token")
            );
            result.add(user);
        }
        return result;
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        String query =
                "SELECT id FROM users " +
                "WHERE username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public void create(User user) throws SQLException {
        String query =
                "INSERT INTO users(username, password, email) " +
                "VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.execute();
    }

    @Override
    public void updateToken(User user) throws SQLException {
        String query =
                "UPDATE users " +
                "SET token=? " +
                "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getToken());
        preparedStatement.setInt(2, user.getId());
        preparedStatement.execute();
    }

    @Override
    public User findByToken(String token) throws SQLException {
        String query =
                "SELECT id, username, password, email " +
                "FROM users " +
                "WHERE token=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, token);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    token
            );
        }
        return user;
    }

    @Override
    public void addRole(int userId, Role role) throws SQLException {
        String query =
                "INSERT INTO user_to_role(user_id, role_id) " +
                "VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, role.getId());
        preparedStatement.execute();
    }

    @Override
    public void removeToken(String token) throws SQLException {
        String query =
                "UPDATE users " +
                "SET token=NULL " +
                "WHERE token=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, token);
        preparedStatement.execute();
    }

    @Override
    public void update(User user) throws SQLException {
        String query =
                "UPDATE users " +
                "SET username=?, password=?, email=?, token=? " +
                "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getToken());
        preparedStatement.setInt(5, user.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query =
                "DELETE FROM users " +
                "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    @Override
    public User findById(int id) throws SQLException {
        String query =
                "SELECT username, password, email, token " +
                "FROM users " +
                "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    id,
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("token")
            );
        }
        return null;
    }
}
