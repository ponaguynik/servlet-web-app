package com.ponagayba.dao;

import com.ponagayba.model.Category;

import java.util.List;

public interface CategoryDao extends GenericDao<Category> {

    List<Category> getAll();
}
