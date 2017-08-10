package com.ponagayba.service;

import com.ponagayba.dao.CategoryDao;
import com.ponagayba.model.Category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final ProductService productService;

    public CategoryServiceImpl(CategoryDao categoryDao, ProductService productService) {
        this.categoryDao = categoryDao;
        this.productService = productService;
    }

    @Override
    public Category getCategoryByName(String name) throws SQLException {
        Category result = null;
        for (Category category : categoryDao.getAll()) {
            if (category.getName().equals(name)) {
                result = category;
            }
        }

        if (result != null) {
            result.setProducts(productService.getAllOfCategory(result.getId()));
        }
        return result;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return categoryDao.getAll();
    }

    @Override
    public void close() throws SQLException {
        categoryDao.close();
        productService.close();
    }
}
