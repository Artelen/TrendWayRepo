package com.Trend.NotificationService.event;

public class StockCountLessThanThreeEvent {
    public String fullName;
    public String eMail;
    public String productName;

    public StockCountLessThanThreeEvent(String fullName, String eMail, String productName) {
        this.fullName = fullName;
        this.eMail = eMail;
        this.productName = productName;
    }

    public StockCountLessThanThreeEvent() {
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
        return "StockCountLessThanThreeEvent{" +
                "fullName='" + fullName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
