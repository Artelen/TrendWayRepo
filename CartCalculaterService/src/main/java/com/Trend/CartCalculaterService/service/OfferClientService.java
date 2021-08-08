package com.Trend.CartCalculaterService.service;

import com.Trend.CartCalculaterService.entity.CargoOffer;
import com.Trend.CartCalculaterService.entity.CargoOfferList;
import com.Trend.CartCalculaterService.entity.PercentageDiscountInCartOffer;
import com.Trend.CartCalculaterService.entity.CartOfferList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OfferClientService {
    @Autowired
    private RestTemplate template;
    @Value("${offerApiAddress}")
    private String offerServiceUrl;


    public List<PercentageDiscountInCartOffer> getCartOffers(){
        String url=offerServiceUrl+"/offer/CartOffers";
        ResponseEntity<CartOfferList> responseEntity=template.getForEntity(url,CartOfferList.class);
        return responseEntity.getBody().getPercentageDiscountInCartOffers();
    }

    public List<CargoOffer> getCargoOffers(){
        String url=offerServiceUrl+"/offer/CargoOffers";
        ResponseEntity<CargoOfferList> responseEntity=template.getForEntity(url,CargoOfferList.class);
        return responseEntity.getBody().getCargoOffers();
    }

}
