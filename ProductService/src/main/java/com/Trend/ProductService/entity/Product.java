package com.Trend.ProductService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;
@Document
public class Product {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;
    @Field
    @QueryIndexed
    private String barcode;
    @Field
    private String description;
    @Field
    private double salesPrice;
    @Field
    private int stockCount;
    @Field
    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Product() {
    }

    public Product(String barcode, String description, double salesPrice,Long companyId) {
        this.barcode = barcode;
        this.description = description;
        this.salesPrice = salesPrice;
        this.stockCount=0;
        this.companyId=companyId;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", salesPrice=" + salesPrice +
                '}';
    }
}