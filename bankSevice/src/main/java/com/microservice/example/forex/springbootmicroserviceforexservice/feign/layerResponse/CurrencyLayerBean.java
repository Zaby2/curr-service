package com.microservice.example.forex.springbootmicroserviceforexservice.feign.layerResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyLayerBean {
    private String from;
    private String to;
    private BigDecimal conversionIndex;
}
