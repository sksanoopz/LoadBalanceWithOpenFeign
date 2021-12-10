package com.dailycodechallenge.prodctcalculator.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.pqc.math.linearalgebra.BigEndianConversions;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCalculator {

    private int productID;
    private String productCode;
    private BigDecimal productRate;
    private BigDecimal productQuantity;
    private BigDecimal totalPrice;
    private String port;

}
