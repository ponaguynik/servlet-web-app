package com.ponagayba.service;

import com.ponagayba.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends AutoCloseable {

    List<Product> getAllOfCategory(int id) throws SQLException;

    Product getProduct(int id) throws SQLException;

    @Override
    void close() throws SQLException;
}
