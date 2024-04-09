package com.microservice.example.forex.springbootmicroserviceforexservice.feign;

import com.microservice.example.forex.springbootmicroserviceforexservice.feign.layerResponse.CurrencyLayerBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("currency-service")
public interface CurrencyLayerApi {
    @GetMapping("/cur-data/live/{live}")
    public List<CurrencyLayerBean> currencyData(@PathVariable String live);
}
