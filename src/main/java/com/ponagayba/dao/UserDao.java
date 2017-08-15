package com.ponagayba.dao;

import com.ponagayba.model.Role;
import com.ponagayba.model.User;

import java.sql.SQLException;

public interface UserDao extends GenericDao<User> {

    User getUser(User user) throws SQLException;

    boolean userExists(String username) throws SQLException;

    void updateToken(User user) throws SQLException;

    User findByToken(String token) throws SQLException;

    void removeToken(String token) throws SQLException;

    void addRole(int userId, Role role) throws SQLException;
}
