package com.Trend.BasketService.service;

import com.Trend.BasketService.entity.Cart;
import com.Trend.BasketService.entity.Product;
import com.Trend.BasketService.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final KafkaProducerService kafkaProducerService;

    public CartService(CartRepository cartRepository, KafkaProducerService kafkaProducerService) {
        this.cartRepository = cartRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public Cart findById(Long id)
    {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart Not Found"));
    }

    public Cart createCart(Cart cart)
    {
        return cartRepository.save(cart);
    }

    public List<Cart> findAllCarts()
    {
        return cartRepository.findAll();
    }

    public Cart updateCart(Cart cart)
    {
        return cartRepository.save(cart);
    }
    public void addProduct(Long userId ,Product product)
    {
        Cart cart cartRepository.findById(userId).orElse();
        cart.
    }
    public void calculateBasketInfo(Cart cart)
    {

    }
}
