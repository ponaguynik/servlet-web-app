package com.ponagayba.dao;

import com.ponagayba.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends GenericDao<Product> {

    List<Product> getAllOfCategory(int id) throws SQLException;
}
