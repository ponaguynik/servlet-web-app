package com.ponagayba.dao;

import com.ponagayba.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    private static Map<String, List<Product>> products = new HashMap<>();

    static {
        List<Product> laptops = new ArrayList<>();
        laptops.add(new Product(1L, "laptops", "Lenovo Laptop", 800.0));
        laptops.add(new Product(2L, "laptops", "Dell Laptop", 1000.0));
        laptops.add(new Product(3L, "laptops", "Asus Laptop", 1500.0));
        products.put("laptops", laptops);

        List<Product> tablets = new ArrayList<>();
        tablets.add(new Product(4L, "tablets", "Lenovo Tablet", 300.0));
        tablets.add(new Product(5L, "tablets", "Asus Tablet", 500.0));
        tablets.add(new Product(6L, "tablets", "Apple Tablet", 800.0));
        products.put("tablets", tablets);

        List<Product> tvs = new ArrayList<>();
        tvs.add(new Product(7L, "tvs", "Panasonic", 400.0));
        tvs.add(new Product(8L, "tvs", "LG", 600.0));
        tvs.add(new Product(9L, "tvs", "Sony", 700.0));
        products.put("tvs", tvs);
    }

    @Override
    public List<Product> getAllOfCategory(String categoryName) {
        List<Product> result = products.get(categoryName);
        if (result == null)
            return null;
        return new ArrayList<>(products.get(categoryName));
    }

    @Override
    public Product getProductByName(String category, String name) {
        for (Product product : products.get(category)) {
            if (product.getName().equals(name))
                return product;
        }
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }

    @Override
    public Product findById(Product product) {
        return null;
    }
}
