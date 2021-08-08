package com.Trend.BasketService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

public class ProductEntity {
    private String id;
    private String barcode;
    private String description;
    private double salesPrice;
    private int stockCount;

    public String getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getDescription() {
        return description;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
