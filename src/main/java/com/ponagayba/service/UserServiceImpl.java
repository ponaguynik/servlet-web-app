package com.ponagayba.service;

import com.ponagayba.dao.UserDao;
import com.ponagayba.model.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(User user) throws SQLException {
        return userDao.getUser(user);
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        return userDao.userExists(username);
    }

    @Override
    public boolean createNewUser(User user) throws SQLException {
        if (userDao.userExists(user.getUsername()))
            return false;
        userDao.create(user);
        return true;
    }

    @Override
    public void close() throws SQLException {
        userDao.close();
    }
}
