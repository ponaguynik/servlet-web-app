package com.ponagayba.service;

import com.ponagayba.dao.UserDao;
import com.ponagayba.model.User;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
