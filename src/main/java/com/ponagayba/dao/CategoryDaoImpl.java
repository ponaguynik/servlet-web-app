package com.ponagayba.dao;

import com.ponagayba.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

    public CategoryDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Category category) throws SQLException {

    }

    @Override
    public void update(Category category) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Category findById(int id) throws SQLException {

        return null;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        String query = "SELECT id, name FROM categories";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Category> result = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            result.add(new Category(id, name));
        }
        return result;
    }
}
