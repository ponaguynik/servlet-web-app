package com.ponagayba.model;

public class Product {

    //Primary key
    private Long id;
    //Foreign key
    private String category;
    private String name;
    private Double price;

    public Product(Long id, String category, String name, Double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
