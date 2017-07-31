package com.ponagayba.dao;

import com.ponagayba.model.User;

public interface UserDao extends GenericDao<User> {

    User getUser(User user);
}
