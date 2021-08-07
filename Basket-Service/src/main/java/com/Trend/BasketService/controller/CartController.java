package com.Trend.BasketService.controller;

import com.Trend.BasketService.entity.Cart;
import com.Trend.BasketService.entity.Product;
import com.Trend.BasketService.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/findbyid")
    public Cart findById(@RequestParam Long id){
        System.out.println(String.format("CartController :: findById :: CartId = %s",id));
        return this.cartService.findById(id);
    }

    @PostMapping("/create")
    public Cart createCart(@RequestBody Cart cart){
        System.out.println("CartController :: createCart :: "+cart.toString());
        return this.cartService.createCart(cart);
    }

    @PostMapping("/delete")
    public  void deleteById(@RequestParam Long id)
    {
        System.out.println(String.format("CartController :: deleteById :: CartId = %s",id));
        cartService.deleteCartByUserId(id);
    }

    @GetMapping("/findAllCarts")
    public List<Cart> findAllCarts()
    {
        return cartService.findAllCarts();
    }
    @PostMapping("/addProduct")
    public void addProduct(@RequestParam Long userId, @RequestBody Product product)
    {
        cartService.addProduct(userId,product);
    }

    @PostMapping("/removeProduct")
    public void removeProduct(@RequestParam Long userId, @RequestBody Product product)
    {
        cartService.removeProduct(userId,product);
    }

    @PostMapping("/clearCart")
    public void clearCart(@RequestParam Long userId)
    {
        cartService.clearCart(userId);
    }
}
