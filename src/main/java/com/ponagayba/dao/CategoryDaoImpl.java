package com.ponagayba.dao;

import com.ponagayba.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category("laptops", null));
        categories.add(new Category("tablets", null));
        categories.add(new Category("tvs", null));
    }

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category delete(Category category) {
        return null;
    }

    @Override
    public Category findById(Category category) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(categories);
    }
}