package com.ponagayba.dao;

import com.ponagayba.model.Role;
import com.ponagayba.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl extends AbstractDao implements RoleDao {

    public RoleDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        String query =
                "SELECT id, name " +
                "FROM roles";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Role> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));
        }
        return result;
    }

    @Override
    public Role findByName(String name) throws SQLException {
        String query =
                "SELECT id, name " +
                "FROM roles " +
                "WHERE name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            );
        }
        return null;
    }

    @Override
    public List<Role> getUserRoles(int userId) throws SQLException {
        String query =
                "SELECT r.id, r.name " +
                "FROM users u " +
                "JOIN user_to_role ur ON ur.user_id=u.id " +
                "JOIN roles r ON r.id=ur.role_id " +
                "WHERE u.id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Role> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));
        }
        return result;
    }

    @Override
    public void deleteUserRoles(int userId) throws SQLException {
        String query =
                "DELETE FROM user_to_role " +
                "WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
    }

    @Override
    public void create(Role role) throws SQLException {

    }

    @Override
    public void update(Role role) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Role findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void close() throws SQLException {

    }
}
