package com.dailycodechallenge.prodctcalculator.controller;

import com.dailycodechallenge.prodctcalculator.Entity.ProductCalculator;
import com.dailycodechallenge.prodctcalculator.facade.ProductCalculatorProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("productcalculator")
public class ProductCalculatorController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    ProductCalculatorProxy productCalculatorProxy;

    @GetMapping("/{code}/{qty}")
    public ProductCalculator getProductCalulator(@PathVariable String code, @PathVariable BigDecimal qty)
    {
        ProductCalculator  productCalculator = productCalculatorProxy.getProduct(code).getBody();
        return new ProductCalculator().builder()
                .productID(productCalculator.getProductID())
                .productCode(productCalculator.getProductCode())
                .productRate(productCalculator.getProductRate())
                .productQuantity(qty)
                .totalPrice(qty.multiply(productCalculator.getProductRate()))
                .port(productCalculator.getPort())
                .build();
    }
}
