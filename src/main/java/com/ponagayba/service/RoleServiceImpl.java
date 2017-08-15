package com.ponagayba.service;

import com.ponagayba.dao.RoleDao;
import com.ponagayba.model.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return roleDao.getAll();
    }

    @Override
    public List<Role> getUserRoles(int userId) {
        return null;
    }

    @Override
    public Role findByName(String name) throws SQLException {
        return roleDao.findByName(name);
    }

    @Override
    public void close() throws Exception {
        roleDao.close();
    }
}
