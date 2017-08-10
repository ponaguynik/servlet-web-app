package com.ponagayba.dao;


import java.sql.SQLException;

public interface GenericDao<T> extends AutoCloseable {

    void create(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
    T findById(int id) throws SQLException;

    @Override
    void close() throws SQLException;
}
