package com.microservice.example.forex.springbootmicroserviceforexservice;


import jakarta.persistence.Embeddable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExchangeDataRepositoryTest {

    @Autowired
    ExchangeDataRepository exchangeDataRepository;
    ExchangeData exchangeData1;
    ExchangeData exchangeData2;

    @BeforeEach
    public void setUp() {
        exchangeData1 = ExchangeData.builder()
                .to("RUB")
                .from("USD")
                .conversionIndex(BigDecimal.valueOf(11L))
                .build();
        exchangeData2 = ExchangeData.builder()
                .from("ENF")
                .to("EUR")
                .build();
    }
    @Test
    public void deletionTest() {
        exchangeDataRepository.save(exchangeData1);
        exchangeDataRepository.save(exchangeData2);

        exchangeDataRepository.delete(exchangeData1);

        List<ExchangeData> exchangeData = exchangeDataRepository.findAll();

        Assertions.assertEquals(4, exchangeData.size());

    }
    @Test
    public void findByFromAndToTest() {
        exchangeDataRepository.save(exchangeData1);
        exchangeDataRepository.save(exchangeData2);

        ExchangeData result = exchangeDataRepository.findByFromAndTo("USD", "RUB");


        Assertions.assertNotNull(result);
        Assertions.assertEquals(exchangeData1.getConversionIndex(), result.getConversionIndex());

    }

}
