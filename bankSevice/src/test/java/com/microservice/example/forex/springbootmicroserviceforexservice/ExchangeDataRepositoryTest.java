package com.microservice.example.forex.springbootmicroserviceforexservice;


import jakarta.persistence.Embeddable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExchangeDataRepositoryTest {

    @Autowired
    ExchangeDataRepository exchangeDataRepository;
    ExchangeData exchangeData1 = new ExchangeData();
    ExchangeData exchangeData2 = new ExchangeData();

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void findByFromAndToTest() {

    }

}
