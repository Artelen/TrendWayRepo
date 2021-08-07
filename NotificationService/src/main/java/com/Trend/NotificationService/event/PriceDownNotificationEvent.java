package com.Trend.NotificationService.event;

public class PriceDownNotificationEvent {
    public String fullName;
    public String eMail;
    public String productName;
    public String oldPrice;
    public String newPrice;

    public PriceDownNotificationEvent(String fullName, String eMail, String productName, String oldPrice, String newPrice) {
        this.fullName = fullName;
        this.eMail = eMail;
        this.productName = productName;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public PriceDownNotificationEvent() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return "PriceDownNotificationEvent{" +
                "fullName='" + fullName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", productName='" + productName + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", newPrice='" + newPrice + '\'' +
                '}';
    }
}
