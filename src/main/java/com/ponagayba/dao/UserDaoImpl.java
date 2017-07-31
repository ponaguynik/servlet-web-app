package com.ponagayba.dao;

import com.ponagayba.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("TestUser", "1234"));
        users.add(new User("User", "1234"));
        users.add(new User("Test", "1234"));
    }

    @Override
    public User getUser(User user) {
        if (users.contains(user))
            return user;
        else
            return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User findById(User user) {
        return null;
    }
}
