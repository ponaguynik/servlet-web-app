package com.ponagayba.service;

import com.ponagayba.dao.ProductDao;
import com.ponagayba.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllOfCategory(String categoryName) {
        return productDao.getAllOfCategory(categoryName);
    }

    @Override
    public Product getProduct(String category, String name) {
        return productDao.getProductByName(category, name);
    }
}
