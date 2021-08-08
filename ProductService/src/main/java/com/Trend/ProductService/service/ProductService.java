package com.Trend.ProductService.service;

import com.Trend.ProductService.entity.Product;
import com.Trend.ProductService.event.PriceChangeEvent;
import com.Trend.ProductService.event.StockChangeEvent;
import com.Trend.ProductService.reporsitory.ProductRepository;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Value("${kafka.topic-delete-product}")
    private String topicName;
    @Value("${stockNotificationThreshold}")
    private int stockNotificationThreshold;

    private final ProductRepository productRepository;
    private final KafkaProducerService kafkaService;



    public ProductService(ProductRepository productRepository, KafkaProducerService kafkaService) {
        this.productRepository = productRepository;
        this.kafkaService = kafkaService;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(String productId) {
        return this.productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not found Product"));
    }
    public Product findByBarcode(String barcode) {
        return this.productRepository.findByBarcode(barcode);
    }
    public Product create(Product product) {
        if (product.getBarcode() == null) {
            throw new RuntimeException(String.format("Barcode cannot be null"));
        }
        if (product.getBarcode().isEmpty()) {
            throw new RuntimeException(String.format("Barcode cannot be empty"));
        }
        if (productRepository.existsByBarcode(product.getBarcode())) {
            throw new RuntimeException(String.format("There is already a product barcode as: %s", product.getBarcode()));
        }
        return this.productRepository.save(product);
    }

    public void changeSalesPrice(String productId, double Price) {
        Product product = this.findById(productId);
        double oldPrice=product.getSalesPrice();
        double newPrice=Price;
        product.setSalesPrice(Price);
        productRepository.save(product);
        PriceChangeEvent changeModel=new PriceChangeEvent(productId.toString(),oldPrice,Price);
        kafkaService.sendChangePriceMessage(changeModel, "changeSalesPrice");


    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
        kafkaService.sendMessage(id, topicName);
    }

    public void deleteByBarcode(String barcode) {
        boolean existsByBarcode = productRepository.existsByBarcode(barcode);

        if(!existsByBarcode)
            return;
        Product product=productRepository.findByBarcode(barcode);
        productRepository.deleteByBarcode(barcode);
        kafkaService.sendMessage(product.getId().toString(), topicName);
    }

    public void changeStockCount(String id,int newStockCount)
    {
        if(newStockCount<0)
            throw new RuntimeException(String.format("newStockCount cant be lower than 0"));
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Product : %s couldnt found",id)));
        int oldStock=product.getStockCount();
        product.setStockCount(newStockCount);
        productRepository.save(product);
        //Stock 3'ten aşağı düşerse bildirim yolla veya 0 iken yükselirse.
        if(newStockCount<stockNotificationThreshold && oldStock >=stockNotificationThreshold ||(oldStock==0 && newStockCount>0) ||(newStockCount==0 && oldStock>0))
        {
            StockChangeEvent stockChangeEvent=new StockChangeEvent(id,oldStock,newStockCount);
            kafkaService.sendStockChangeEvent(stockChangeEvent,"StockChange");
        }

    }
}
