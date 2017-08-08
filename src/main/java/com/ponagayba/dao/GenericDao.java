package com.ponagayba.dao;


import java.sql.SQLException;

public interface GenericDao<T> {

    boolean create(T t) throws SQLException;
    boolean update(T t);
    boolean delete(T t);
    T findById(T t);
}
