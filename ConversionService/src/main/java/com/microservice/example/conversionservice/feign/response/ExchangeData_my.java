package com.microservice.example.conversionservice.feign.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeData_my {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionIndex;

}
