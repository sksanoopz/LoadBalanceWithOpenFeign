package com.dailycodechallenge.pricemaster.controller;

import com.dailycodechallenge.pricemaster.entity.Product;
import com.dailycodechallenge.pricemaster.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    private Environment environment;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("/saveproduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        product.setPort(environment.getProperty("server.port").toString());
        return productService.saveProduct(product);
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        return productService.getProductInfo(id);
    }

    @GetMapping("/getproductcode/{code}")
    public ResponseEntity<?> getProduct(@PathVariable("code") String code) {
        return productService.getProductInfoByCode(code);
    }

}
