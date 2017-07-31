package com.ponagayba.service;

import com.ponagayba.dao.CategoryDao;
import com.ponagayba.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final ProductService productService;

    public CategoryServiceImpl(CategoryDao categoryDao, ProductService productService) {
        this.categoryDao = categoryDao;
        this.productService = productService;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = categoryDao.getAll();
        for (Category category : categories)
            category.setProducts(productService.getAllOfCategory(category.getName()));
        return categories;
    }
}
