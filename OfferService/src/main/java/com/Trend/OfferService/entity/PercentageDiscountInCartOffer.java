package com.Trend.OfferService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.util.Set;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

public class PercentageDiscountInCartOffer {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;
    @Field
    private String companyId;
    @Field
    private double discountPercentage;
    @Field
    private final Set<String> includedProducts;

    public PercentageDiscountInCartOffer(String companyId, double discountPercentage, Set<String> includedProducts) {
        this.companyId = companyId;
        this.discountPercentage = discountPercentage;
        this.includedProducts = includedProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    @Override
    public String toString() {
        return "PercentageDiscountInCartOffer{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", includedProducts=" + includedProducts +
                '}';
    }
}
