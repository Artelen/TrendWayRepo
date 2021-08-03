package com.Trend.ProductService.controller;

import com.Trend.ProductService.entity.Product;
import com.Trend.ProductService.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/findbyid")
    public Product findById(@RequestParam String id){
        System.out.println(String.format("ProductController :: findById :: ProductId = %s",id));
        return this.productService.findById(id);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        System.out.println("ProductController :: createProduct :: "+product.toString());
        return this.productService.create(product);
    }

    @PostMapping("/delete")
    public  void deleteById(@RequestParam String id)
    {
        System.out.println(String.format("ProductController :: deleteById :: ProductId = %s",id));
        productService.deleteById(id);
    }

    @PutMapping("/changePrice")
    public  void changeSalesPrice(@RequestParam String id,@RequestParam double price)
    {
        System.out.println(String.format("ProductController :: changeWebSalesPrice :: ProductId = %s  price = %s",id,price));
        productService.changeSalesPrice(id,price);
    }

    @PutMapping("/changeStock")
    public  void changeStockCount(@RequestParam String id,@RequestParam int stockCount)
    {
        System.out.println(String.format("ProductController :: changeStock :: ProductId = %s  Stock = %s",id,stockCount));
        productService.changeStockCount(id,stockCount);
    }

}