package com.Trend.CartCalculaterService.entity;

public class CargoOffer {
    private String id;
    private String cargoName;
    private double price;
    private double discountPercentage;
    private double priceThreshold;

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
}
