package com.microservice.example.forex.springbootmicroserviceforexservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExchangeDataRepository extends
        JpaRepository<ExchangeData, Long> {
    ExchangeData findByFromAndTo(String curFrom, String curTO);
}
