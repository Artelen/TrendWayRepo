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
    @QueryIndexed
    private String cargoName;
    @Field
    private double price;
    @Field
    private double discountPercentage;
    @Field
    private double priceThreshold;

    public CargoOffer(String cargoName, double price, double discountPercentage, double priceThreshold) {
        this.cargoName = cargoName;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.priceThreshold = priceThreshold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getPriceThreshold() {
        return priceThreshold;
    }

    public void setPriceThreshold(double priceThreshold) {
        this.priceThreshold = priceThreshold;
    }

    @Override
    public String toString() {
        return "CargoOffer{" +
                "id='" + id + '\'' +
                ", cargoName='" + cargoName + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", priceThreshold=" + priceThreshold +
                '}';
    }
}
