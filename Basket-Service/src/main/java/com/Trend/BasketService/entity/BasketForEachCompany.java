package com.Trend.BasketService.entity;

import java.util.Objects;
import java.util.Set;

public class BasketForEachCompany {
    private String companyId;
    private String companyName;
    private Set<Product> products;
    private BasketInfo semiBasketInfo;

    public BasketForEachCompany(String companyId, String companyName, Set<Product> products, BasketInfo semiBasketInfo) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.products = products;
        this.semiBasketInfo = semiBasketInfo;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public BasketInfo getSemiBasketInfo() {
        return semiBasketInfo;
    }

    public void setSemiBasketInfo(BasketInfo semiBasketInfo) {
        this.semiBasketInfo = semiBasketInfo;
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
            if(product.getQuantity()>1)
                product.decrementQuantity();
            else
                products.remove(product);
        }
        else
            new RuntimeException("There is no product to remove");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasketForEachCompany)) return false;
        BasketForEachCompany that = (BasketForEachCompany) o;
        return Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId);
    }

    @Override
    public String toString() {
        return "\nBasketForEachCompany{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", products=" + products +
                ", semiBasketInfo=" + semiBasketInfo +
                '}';
    }
}
