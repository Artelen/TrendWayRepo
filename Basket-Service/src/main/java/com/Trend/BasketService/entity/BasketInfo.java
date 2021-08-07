package com.Trend.BasketService.entity;

public class BasketInfo {
    private double priceWithOutDiscount;
    private double priceWithDiscount;
    private double cargoPrice;
    private double totalPrice;

    public BasketInfo() {
    }

    public BasketInfo(double priceWithOutDiscount, double priceWithDiscount, double cargoPrice, double totalPrice) {
        this.priceWithOutDiscount = priceWithOutDiscount;
        this.priceWithDiscount = priceWithDiscount;
        this.cargoPrice = cargoPrice;
        this.totalPrice = totalPrice;
    }

    public double getPriceWithOutDiscount() {
        return priceWithOutDiscount;
    }

    public void setPriceWithOutDiscount(double priceWithOutDiscount) {
        this.priceWithOutDiscount = priceWithOutDiscount;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public double getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(double cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "\nBasketInfo{" +
                "priceWithOutDiscount=" + priceWithOutDiscount +
                ", priceWithDiscount=" + priceWithDiscount +
                ", cargoPrice=" + cargoPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
