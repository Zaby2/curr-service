package com.microservice.example.conversionservice.feign;

import com.microservice.example.conversionservice.feign.response.currencyResponse.CurrencyLayerBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("currency-service")
public interface CurrencyLayerApi {
    @GetMapping("/cur-data/live/{live}")
    public List<CurrencyLayerBean> currencyData(@PathVariable String live);
}
