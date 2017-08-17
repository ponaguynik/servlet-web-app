package com.ponagayba.service;

import com.ponagayba.dao.RoleDao;
import com.ponagayba.dao.UserDao;
import com.ponagayba.model.Role;
import com.ponagayba.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User getUser(User user) throws SQLException {
        User result = userDao.getUser(user);
        if (result != null) {
            result.setRoles(roleDao.getUserRoles(result.getId()));
        }
        return result;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> result = userDao.getAll();
        for (User user : result) {
            user.setRoles(roleDao.getUserRoles(user.getId()));
        }
        return result;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        roleDao.deleteUserRoles(id);
        userDao.delete(id);
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        return userDao.userExists(username);
    }

    @Override
    public void createNewUser(User user) throws SQLException {
        userDao.create(user);
        User userDB = userDao.getUser(new User(user.getUsername(), user.getPassword()));
        for (Role role : user.getRoles()) {
            userDao.addRole(userDB.getId(), role);
        }
    }

    @Override
    public void updateToken(User user) throws SQLException {
        userDao.updateToken(user);
    }

    @Override
    public User findById(int id) throws SQLException {
        User result = userDao.findById(id);
        if (result != null) {
            result.setRoles(roleDao.getUserRoles(result.getId()));
        }
        return result;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.update(user);
    }

    @Override
    public User findByToken(String token) throws SQLException {
        User result = userDao.findByToken(token);
        if (result != null) {
            result.setRoles(roleDao.getUserRoles(result.getId()));
        }
        return result;
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
