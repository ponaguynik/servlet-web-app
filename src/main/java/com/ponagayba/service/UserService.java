package com.ponagayba.service;

import com.ponagayba.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface UserService extends AutoCloseable {

    User getUser(User user) throws SQLException;

    List<User> getAll() throws SQLException;

    boolean userExists(String username) throws SQLException;

    void createNewUser(User user) throws SQLException;

    void updateToken(User user) throws SQLException;

    @Override
    void close() throws SQLException;

    User findByToken(String token) throws SQLException;

    void deleteUser(int id) throws SQLException;

    void removeToken(String token) throws SQLException;

    User findById(int id) throws SQLException;

    void updateUser(User user) throws SQLException;
}
