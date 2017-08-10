package com.ponagayba.dao;

import com.ponagayba.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends AbstractDao implements ProductDao {

    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> getAllOfCategory(int id) throws SQLException {
        List<Product> result = new ArrayList<>();
        String query =
                "SELECT products.id AS id, categories.name AS category, products.name AS name, products.price AS price " +
                "FROM products " +
                "JOIN categories " +
                "ON products.category_id=categories.id " +
                "WHERE category_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int product_id = resultSet.getInt("id");
            String category = resultSet.getString("category");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            Product product = new Product(product_id, category, name, price);
            result.add(product);
        }
        return result;
    }

    @Override
    public Product findById(int id) throws SQLException {
        String query =
                "SELECT categories.name AS category, products.name AS name, products.price AS price " +
                "FROM products " +
                "JOIN categories " +
                "ON products.category_id=categories.id " +
                "WHERE products.id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String category = resultSet.getString("category");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            return new Product(id, category, name, price);
        }
        return null;
    }

    @Override
    public void create(Product product) throws SQLException {

    }

    @Override
    public void update(Product product) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
