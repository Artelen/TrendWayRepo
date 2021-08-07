package com.Trend.BasketService.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Set;

@Document
public class Cart {
    @Id
    private Long userId;
    @Field
    private Set<Product> products;
    @Field
    private BasketInfo basketInfo;

    public Cart(Long userId) {
        this.userId = userId;
    }

    public Cart() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setBasketInfo(BasketInfo basketInfo) {
        this.basketInfo = basketInfo;
    }

    @Autowired
    public Cart(Long userId, Set<Product> products, BasketInfo basketInfo) {
        this.userId = userId;
        this.products = products;
        this.basketInfo = basketInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    public void addProduct(Product product)
    {
        if (products.contains(product))
        {
            products.stream().
                    filter((x)->x.equals(product)).
                    findAny().orElseThrow(()->new RuntimeException("The product should have been here")).incrementQuantity();
        }
        else
            products.add(product);

    }
    public void removeProduct(Product product)
    {
        if (products.contains(product))
        {
            Product productToUpdate= products.stream().
                    filter((x)->x.equals(product)).
                    findAny().orElseThrow(()->new RuntimeException("The product should have been here"));
            if(productToUpdate.getQuantity()>1)
                productToUpdate.decrementQuantity();
            else
                products.remove(product);
        }
        else
            new RuntimeException("There is no product to remove");
    }

    public void removeProductCompletely(String productId)
    {
        products.remove(products.stream().
                filter(
                        (x)->x.getId().equals(productId)).
                findAny().
                orElseThrow(()->new RuntimeException("There no prodcut to remove")));
    }

    public void clearCart()
    {
        products.clear();
    }

    public Product getProduct(String id)
    {
        return products.stream().filter((x)->x.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", \nproducts=" + products +
                ", \nbasketInfo=" + basketInfo +
                '}';
    }
}
