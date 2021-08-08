package com.Trend.CartCalculaterService.entity;

import java.util.Set;

public class PercentageDiscountInCartOffer {
    private String id;
    private double discountPercentage;
    private Set<String> includedProducts;

    public PercentageDiscountInCartOffer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Set<String> getIncludedProducts() {
        return includedProducts;
    }

    public void setIncludedProducts(Set<String> includedProducts) {
        this.includedProducts = includedProducts;
    }
}
