package com.ponagayba.dao;

import com.ponagayba.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {

    List<Product> getAllOfCategory(String categoryName);

    Product getProductByName(String category, String name);
}
