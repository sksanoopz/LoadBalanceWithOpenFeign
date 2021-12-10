package com.dailycodechallenge.pricemaster.service;

import com.dailycodechallenge.pricemaster.entity.Product;
import com.dailycodechallenge.pricemaster.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private Environment environment;

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> saveProduct(Product product)
    {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    public Product updateProduct(Product product)
    {
        Optional<Product> existProduct = Optional.ofNullable(productRepository.findByProductCode(product.getProductCode()));
        if (existProduct.isPresent())
            return productRepository.save(product);
        else
            return new Product();
    }

    public ResponseEntity<?> getProductInfo(Long productID)
    {
        return new ResponseEntity<>(productRepository.findById(productID),HttpStatus.OK);
    }

    public List<Product> getAllProduct()
    {
        return productRepository.findAll();
    }

    public ResponseEntity<?> getProductInfoByCode(String code)
    {
        Product product = productRepository.findByProductCode(code);
        product.setPort(environment.getProperty("server.port"));
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
