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
    public void createNewUser(User user) throws SQLException {
        userDao.create(user);
    }

    @Override
    public void updateToken(User user) throws SQLException {
        userDao.updateToken(user);
    }

    @Override
    public User findByToken(String token) throws SQLException {
        return userDao.findByToken(token);
    }

    @Override
    public void removeToken(String token) throws SQLException {
        userDao.removeToken(token);
    }

    @Override
    public void close() throws SQLException {
        userDao.close();
    }
}
