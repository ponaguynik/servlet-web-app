package com.ponagayba.service;

import com.ponagayba.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleService extends AutoCloseable {

    List<Role> getAll() throws SQLException;

    Role findByName(String name) throws SQLException;

    List<Role> getUserRoles(int userId);
}
