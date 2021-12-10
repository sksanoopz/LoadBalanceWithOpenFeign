package com.dailycodechallenge.prodctcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.dailycodechallenge.prodctcalculator")
public class ProdctCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdctCalculatorApplication.class, args);
    }

}
