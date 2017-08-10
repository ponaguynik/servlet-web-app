package com.ponagayba.service;

import com.ponagayba.dao.ProductDao;
import com.ponagayba.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllOfCategory(int id) throws SQLException {
        return productDao.getAllOfCategory(id);
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        return productDao.findById(id);
    }

    @Override
    public void close() throws SQLException {
        productDao.close();
    }
}
