package com.Trend.BasketService.service;

import com.Trend.BasketService.entity.ProductEntity;
import com.Trend.BasketService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClientService {
    @Autowired
    private RestTemplate template;
    @Value("${productApiAddress}")
    private String productServiceUrl;


    public ProductEntity getUser(String id){
        String url=productServiceUrl+"/product/findbyid?id="+id;
        ResponseEntity<ProductEntity> responseEntity=template.getForEntity(url,ProductEntity.class);
        return responseEntity.getBody();
    }
}
