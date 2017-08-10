package com.ponagayba.service;

import com.ponagayba.model.Category;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.List;

public interface CategoryService extends AutoCloseable {

    List<Category> getAll() throws SQLException;

    Category getCategoryByName(String name) throws SQLException;

    @Override
    void close() throws SQLException;
}
