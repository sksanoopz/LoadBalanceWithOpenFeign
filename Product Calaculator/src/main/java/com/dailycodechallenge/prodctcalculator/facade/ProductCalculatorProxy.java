package com.dailycodechallenge.prodctcalculator.facade;

import com.dailycodechallenge.prodctcalculator.Entity.ProductCalculator;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "product-price-master", url="http://localhost:8083")
@FeignClient(name = "product-price-master")
@RibbonClient(name = "product-price-master")
public interface ProductCalculatorProxy {

    @GetMapping("/product/v1/getproductcode/{code}")
    public ResponseEntity<ProductCalculator> getProduct(@PathVariable("code") String code);

}
