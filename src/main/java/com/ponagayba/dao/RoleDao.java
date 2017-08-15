package com.ponagayba.dao;

import com.ponagayba.model.Role;

import java.sql.SQLException;
import java.util.List;


public interface RoleDao extends GenericDao<Role> {

    List<Role> getAll() throws SQLException;

    Role findByName(String name) throws SQLException;

    List<Role> getUserRoles(int userId) throws SQLException;
}
