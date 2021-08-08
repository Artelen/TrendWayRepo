package com.Trend.CartCalculaterService.entity;

import java.util.List;

public class ProductWrapper {
    List<Product> products;

    public ProductWrapper(List<Product> products) {
        this.products = products;
    }

    public ProductWrapper() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
