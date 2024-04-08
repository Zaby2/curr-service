package com.microservice.example.conversionservice.feign;

import com.microservice.example.conversionservice.feign.response.ExchangeData_my;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bank-service")
public interface BankServiceApi {
    @GetMapping("/cur-ex/from/{curFrom}/to/{curTO}")
    public ExchangeData_my retrieveExchangeValueM(@PathVariable String curFrom, @PathVariable String curTO);

}
