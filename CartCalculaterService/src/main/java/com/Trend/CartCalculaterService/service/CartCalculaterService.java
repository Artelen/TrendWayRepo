package com.Trend.CartCalculaterService.service;

import com.Trend.CartCalculaterService.entity.CargoOffer;
import com.Trend.CartCalculaterService.entity.CartInfo;
import com.Trend.CartCalculaterService.entity.PercentageDiscountInCartOffer;
import com.Trend.CartCalculaterService.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartCalculaterService {
    private final OfferClientService offerClientService;

    public CartCalculaterService(OfferClientService offerClientService) {
        this.offerClientService = offerClientService;
    }

    public CartInfo calculateCartInfo(List<Product> products)
    {
        double priceWithOutDiscount=0;
        double priceWithDiscount=0;
        double cargoPrice=10000;
        double totalPrice=0;
        List<PercentageDiscountInCartOffer> cartOffers = offerClientService.getCartOffers();
        List<CargoOffer> cargoOffers = offerClientService.getCargoOffers();
        if(cartOffers==null)
        {
            cartOffers=new ArrayList<>();
        }
        if(cargoOffers==null)
        {
            cargoOffers=new ArrayList<>();
        }


        for(int k=0;k<products.size();k++)
        {
            Product product = products.get(k);
            double minPrice=product.getPrice();
            priceWithOutDiscount+=product.getPrice()*product.getQuantity();
            for(int i=0;i < cartOffers.size();i++)
            {
                PercentageDiscountInCartOffer cartOffer = cartOffers.get(i);
                if(cartOffer.getIncludedProducts().contains(product.getId()))
                {
                    double discountedPrice= product.getPrice()-(product.getPrice()*cartOffer.getDiscountPercentage()/100);
                    if(discountedPrice < minPrice)
                        minPrice=discountedPrice;
                }
            }
            priceWithDiscount+=minPrice*product.getQuantity();
        }


        String bestCargoName="";
        for (int i=0;i<cargoOffers.size();i++) {
            CargoOffer offer = cargoOffers.get(i);
            double price = offer.getPrice();
            if (priceWithDiscount >= offer.getPriceThreshold()) {
                price = offer.getPrice() - (offer.getPrice() * offer.getDiscountPercentage()/100);
            }
            if (price < cargoPrice) {
                cargoPrice = price;
                bestCargoName = offer.getCargoName();
            }
        }
        totalPrice=cargoPrice+priceWithDiscount;

        CartInfo cartInfo = new CartInfo();

        cartInfo.setCargoPrice(cargoPrice);
        cartInfo.setPriceWithOutDiscount(priceWithOutDiscount);
        cartInfo.setTotalPrice(totalPrice);
        cartInfo.setPriceWithDiscount(priceWithDiscount);

        return cartInfo;
    }
}
