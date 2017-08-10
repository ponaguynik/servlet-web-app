package com.ponagayba.service;

import com.ponagayba.model.User;

import java.sql.SQLException;

public interface UserService extends AutoCloseable {

    User getUser(User user) throws SQLException;

    boolean userExists(String username) throws SQLException;

    boolean createNewUser(User user) throws SQLException;

    @Override
    void close() throws SQLException;
}
