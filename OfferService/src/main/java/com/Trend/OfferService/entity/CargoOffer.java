package com.Trend.OfferService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Document
public class CargoOffer {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;
    @Field
    private String companyId;
    @Field
    @QueryIndexed
    private String cargoName;
    @Field
    private double discountPercentage;

    public CargoOffer(String companyId, String cargoName, double discountPercentage) {
        this.companyId = companyId;
        this.cargoName = cargoName;
        this.discountPercentage = discountPercentage;
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

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "CargoOffer{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", cargoName='" + cargoName + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
