package com.Trend.CartCalculaterService.entity;

public class CartInfo {
    private double priceWithOutDiscount;
    private double priceWithDiscount;
    private double cargoPrice;
    private double totalPrice;

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
}
