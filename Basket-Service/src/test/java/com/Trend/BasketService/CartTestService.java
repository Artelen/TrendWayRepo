package com.Trend.BasketService;

import com.Trend.BasketService.repository.CartRepository;
import com.Trend.BasketService.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void createCart()
    {

    }
}
