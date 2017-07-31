package com.ponagayba.service;

import com.ponagayba.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllOfCategory(String categoryName);
}
