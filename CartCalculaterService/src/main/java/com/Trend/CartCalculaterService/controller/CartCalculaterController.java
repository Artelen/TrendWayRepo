package com.Trend.CartCalculaterService.controller;

import com.Trend.CartCalculaterService.entity.CartInfo;
import com.Trend.CartCalculaterService.entity.Product;
import com.Trend.CartCalculaterService.entity.ProductWrapper;
import com.Trend.CartCalculaterService.service.CartCalculaterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("cartController")
public class CartCalculaterController {

    private final CartCalculaterService cartCalculaterService;

    public CartCalculaterController(CartCalculaterService cartCalculaterService) {
        this.cartCalculaterService = cartCalculaterService;
    }

    @PostMapping( path="/calculateCartInfo", consumes = "application/json", produces = "application/json")
    public CartInfo calculateCartInfo(@RequestBody ProductWrapper wrapper)
    {
        return cartCalculaterService.calculateCartInfo(wrapper.getProducts());
    }
}
