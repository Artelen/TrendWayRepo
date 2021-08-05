package com.Trend.BasketService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Set;

@Document
public class Cart {
    @Id
    private final Long userId;
    @Field
    private final Set<BasketForEachCompany> semiBaskets;
    @Field
    private final BasketInfo basketInfo;

    public Cart(Long userId, Set<BasketForEachCompany> semiBaskets, BasketInfo basketInfo) {
        this.userId = userId;
        this.semiBaskets = semiBaskets;
        this.basketInfo = basketInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public Set<BasketForEachCompany> getSemiBaskets() {
        return semiBaskets;
    }

    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    public void addProduct(Product product)
    {
        
    }
    @Override
    public String toString() {
        return "Cart{" +
                "userId='" + userId + '\'' +
                ", semiBaskets=" + semiBaskets +
                ", basketInfo=" + basketInfo +
                '}';
    }
}
