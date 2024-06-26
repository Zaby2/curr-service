package com.microservice.example.currencylayerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class CurrencyLayerController {
    @Autowired
   CurrencyLayerService currencyLayerService;

    @GetMapping("/cur-data/live/{live}")
    public List<CurrencyLayerBean> currencyData(@PathVariable String live,
                                                @CookieValue(name="auth_token", defaultValue = "") String token)
    {
        // here validation pf token need to be added
        if(token.isEmpty()) {
            return null;
        }
        return currencyLayerService.getCurrencyData();
    }
}
