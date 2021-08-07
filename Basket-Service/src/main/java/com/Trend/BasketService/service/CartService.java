package com.Trend.BasketService.service;

import com.Trend.BasketService.entity.BasketInfo;
import com.Trend.BasketService.entity.Cart;
import com.Trend.BasketService.entity.Product;
import com.Trend.BasketService.entity.User;
import com.Trend.BasketService.event.*;
import com.Trend.BasketService.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.HashSet;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final KafkaProducerService kafkaProducerService;
    private final UserClientService userClientService;

    public CartService(CartRepository cartRepository, KafkaProducerService kafkaProducerService, UserClientService userClientService) {
        this.cartRepository = cartRepository;
        this.kafkaProducerService = kafkaProducerService;
        this.userClientService = userClientService;
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

    public void deleteCart(Cart cart)
    {
        cartRepository.deleteById(cart.getUserId());
    }

    public void deleteCartByUserId(Long userId)
    {
        cartRepository.deleteById(userId);
    }

    public void addProduct(Long userId ,Product product)
    {
        Cart cart= cartRepository.findById(userId).orElse(new Cart(userId,new HashSet<Product>(),new BasketInfo()));
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    public void removeProduct(Long userId,Product product)
    {
        Cart cart= cartRepository.findById(userId).orElseThrow(()->new RuntimeException("There is no Cart to remove from it."));
        cart.removeProduct(product);
        cartRepository.save(cart);
    }

    public void clearCart(Long userId)
    {
        Cart cart = cartRepository.findById(userId).orElseThrow(()->new RuntimeException("There is no Cart to clear it."));
        cart.clearCart();
        cartRepository.save(cart);
    }

    public void removeProductCompeletely(String productId)
    {

        findAllCarts().stream().peek(
                (x)->{
                    x.removeProductCompletely(productId);
                    cartRepository.save(x);
                }
        );
    }

    public void sendPriceChangeEvent(PriceChangeEvent priceChangeEvent)
    {
        System.out.println(cartRepository.findAll().stream());
        cartRepository.findAll().stream().forEach(
                (x)->{
                    if(x.getProducts().contains(new Product(priceChangeEvent.getProductId())))
                    {
                        Product product= x.getProduct(priceChangeEvent.getProductId());
                        product.setPrice(priceChangeEvent.getNewPrice());
                        this.updateCart(x);
                        User user = userClientService.getUser(x.getUserId());
                        PriceDownNotificationEvent priceDownNotificationEvent = new PriceDownNotificationEvent(
                                user.getFullName(),
                                user.getEmail(),
                                product.getName(),
                                String.valueOf(priceChangeEvent.getOldPrice()) ,
                                String.valueOf(priceChangeEvent.getNewPrice()));

                        System.out.println("sendPriceDownNotificationEvent :: priceDownNotificationEvent = "+priceDownNotificationEvent);
                        kafkaProducerService.sendPriceDownNotificationEvent(priceDownNotificationEvent);
                    }
                }
        );

    }
    public void sendStockCountChangeEvent(StockChangeEvent stockChangeEvent)
    {

        cartRepository.findAll().stream().forEach(
                (x)->{
                    if(x.getProducts().contains(new Product(stockChangeEvent.getProductId())))
                    {
                        User user = userClientService.getUser(x.getUserId());
                        if(stockChangeEvent.getNewStock()==0)
                        {
                            StockCountZeroEvent stockCountZeroEvent=new StockCountZeroEvent(
                                    user.getFullName()
                                    ,user.getEmail(),
                                    x.getProduct(stockChangeEvent.getProductId()).getName());
                            System.out.println("sendStockCountZeroEvent :stockCountZeroEvent = "+stockCountZeroEvent);
                            kafkaProducerService.sendStockCountZeroEvent(stockCountZeroEvent);
                        }
                        else if(stockChangeEvent.getOldStock()==0 && stockChangeEvent.getNewStock()>0)
                        {
                            StockCountIncreasedFromZeroEvent stockCountIncreasedFromZeroEvent=new StockCountIncreasedFromZeroEvent(
                                    user.getFullName()
                                    ,user.getEmail(),
                                    x.getProduct(stockChangeEvent.getProductId()).getName());
                            System.out.println("sendStockCountZeroEvent :stockCountZeroEvent = "+stockCountIncreasedFromZeroEvent);
                            kafkaProducerService.sendStockCountIncreasedFromZeroEvent(stockCountIncreasedFromZeroEvent);
                        }
                        else
                        {
                            StockCountLessThanThreeEvent stockCountLessThanThreeEvent=new StockCountLessThanThreeEvent(
                                    user.getFullName(),
                                    user.getEmail(),
                                    x.getProduct(stockChangeEvent.getProductId()).getName());
                            System.out.println("sendStockCountLessThanThreeEvent :: stockCountLessThanThreeEvent = "+stockCountLessThanThreeEvent);
                            kafkaProducerService.sendStockCountLessThanThreeEvent(stockCountLessThanThreeEvent);

                        }


                    }
                }
        );

    }
    public void calculateBasketInfo(Cart cart)
    {

    }
}
