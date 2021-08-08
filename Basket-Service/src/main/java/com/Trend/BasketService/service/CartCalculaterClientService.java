package com.Trend.BasketService.service;

import com.Trend.BasketService.entity.BasketInfo;
import com.Trend.BasketService.entity.Product;
import com.Trend.BasketService.entity.ProductWrapper;
import com.Trend.BasketService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartCalculaterClientService {
    @Autowired
    private RestTemplate template;
    @Value("${cartCalculaterApiAddress}")
    private String cartCalculateServiceUrl;



    public BasketInfo calculateBasketInfo(@RequestBody List<Product> products){
        String url=cartCalculateServiceUrl+"/cartController/calculateCartInfo";
        ResponseEntity<BasketInfo> responseEntity=template.postForEntity(url,new ProductWrapper(products),BasketInfo.class);
        return responseEntity.getBody();
    }
}
