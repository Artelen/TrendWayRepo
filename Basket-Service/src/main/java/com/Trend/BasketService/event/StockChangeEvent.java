package com.Trend.BasketService.event;

public class StockChangeEvent {
    private String productId;
    private int oldStock;
    private int newStock;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getOldStock() {
        return oldStock;
    }

    public void setOldStock(int oldStock) {
        this.oldStock = oldStock;
    }

    public int getNewStock() {
        return newStock;
    }

    public void setNewStock(int newStock) {
        this.newStock = newStock;
    }

    public StockChangeEvent() {
    }

    public StockChangeEvent(String productId, int oldStock, int newStock) {
        this.productId = productId;
        this.oldStock = oldStock;
        this.newStock = newStock;
    }

    @Override
    public String toString() {
        return "StockChangeEvent{" +
                "productId='" + productId + '\'' +
                ", oldStock=" + oldStock +
                ", newStock=" + newStock +
                '}';
    }
}
