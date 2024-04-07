package com.microservice.example.conversionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("bank-service")
public interface BankServiceApi {
}
