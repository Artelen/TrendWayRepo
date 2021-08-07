package com.Trend.BasketService.Service;

import com.Trend.BasketService.entity.BasketInfo;
import com.Trend.BasketService.entity.Cart;
import com.Trend.BasketService.entity.Product;
import com.Trend.BasketService.repository.CartRepository;
import com.Trend.BasketService.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
public class CartTestService {
    private final CartService cartService;
    private final CartRepository cartRepository;

    @Autowired
    public CartTestService(CartService cartService, CartRepository cartRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

    @Test
    public void createCart() {
        cartService.deleteCartByUserId(1L);
        cartService.deleteCartByUserId(2L);
        cartService.deleteCartByUserId(3L);
        Product p1=new Product("1","p1","url",1,10);
        Product p2=new Product("2","p2","url",1,20);
        Product p3=new Product("3","p3","url",1,30);
        Product p4=new Product("4","p4","url",1,40);
        cartService.addProduct(1L,p1);
        cartService.addProduct(1L,p1);
        cartService.addProduct(1L,p2);
        cartService.addProduct(2L,p3);
        cartService.addProduct(3L,p4);

        System.out.println(cartService.findAllCarts());
        Assertions.assertEquals(3, cartRepository.count());
    }
}
