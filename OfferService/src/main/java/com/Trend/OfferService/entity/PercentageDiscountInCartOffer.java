package com.Trend.OfferService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.util.Set;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

public class PercentageDiscountInCartOffer {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;
    @Field
    private double discountPercentage;
    @Field
    private  Set<String> includedProducts;

    public PercentageDiscountInCartOffer(double discountPercentage, Set<String> includedProducts) {
        this.discountPercentage = discountPercentage;
        this.includedProducts = includedProducts;
    }

    public PercentageDiscountInCartOffer(String id, double discountPercentage, Set<String> includedProducts) {
        this.id = id;
        this.discountPercentage = discountPercentage;
        this.includedProducts = includedProducts;
    }

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

    public void addProduct(String id)
    {
        includedProducts.add(id);
    }
    @Override
    public String toString() {
        return "PercentageDiscountInCartOffer{" +
                "id='" + id + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", includedProducts=" + includedProducts +
                '}';
    }
}
