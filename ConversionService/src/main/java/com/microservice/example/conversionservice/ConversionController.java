package com.microservice.example.conversionservice;


import com.microservice.example.conversionservice.feign.BankServiceApi;
import com.microservice.example.conversionservice.feign.response.ExchangeData_my;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversionController {

    @Autowired
    BankServiceApi bankServiceApi;

   // private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); // this thing saves everything that happens in the code\

    @GetMapping("/conv-cur/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean conversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String > pathVariables = new HashMap<>();
        pathVariables.put("from", from);
        pathVariables.put("to", to);
        ExchangeData_my result = bankServiceApi.retrieveExchangeValueM(from, to);
        return new ConversionBean(result.getId(), from, to, result.getConversionIndex(), quantity, quantity.multiply(result.getConversionIndex()), 0);
    }
}
