package com.Trend.NotificationService.event;

public class StockCountIncreasedFromZeroEvent {
    public String fullName;
    public String eMail;
    public String productName;

    public StockCountIncreasedFromZeroEvent(String fullName, String eMail, String productName) {
        this.fullName = fullName;
        this.eMail = eMail;
        this.productName = productName;
    }

    public StockCountIncreasedFromZeroEvent() {
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

    @Override
    public String toString() {
        return "StockCountIncreasedFromZeroEvent{" +
                "fullName='" + fullName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
