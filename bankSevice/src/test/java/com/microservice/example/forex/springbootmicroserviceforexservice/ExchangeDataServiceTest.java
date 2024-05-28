package com.microservice.example.forex.springbootmicroserviceforexservice;

import com.microservice.example.forex.springbootmicroserviceforexservice.feign.CurrencyLayerApi;
import com.microservice.example.forex.springbootmicroserviceforexservice.feign.layerResponse.CurrencyLayerBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ExchangeDataServiceTest {
    @Mock
    private ExchangeDataRepository rep;
    @Mock
    Environment environment;
    @Mock
    CurrencyLayerApi currencyLayerApi;
    @InjectMocks
    ExchangeDataService exchangeDataService;

    @BeforeAll
    static void setUp() {
        System.out.println("tests");
    }
    @Test
    void findByFromAndTo() {
        ExchangeData currencyLayerBean1 = new ExchangeData(1L, "USD", "RUB", BigDecimal.ONE, 1);
        ExchangeData currencyLayerBean2 = new ExchangeData(1L, "RUB", "RUN", BigDecimal.ONE, 1);
        ExchangeData currencyLayerBean3 = new ExchangeData(1L, "DSD", "EUR", BigDecimal.ONE, 1);
        ExchangeData currencyLayerBean4 = new ExchangeData(1L, "EUR", "RUN", BigDecimal.ONE, 1);
        Mockito.when(rep.findByFromAndTo("USD", "RUB")).thenReturn(List.of(currencyLayerBean1, currencyLayerBean2, currencyLayerBean3, currencyLayerBean4).stream()
                .filter(currencyLayerBean ->
                        currencyLayerBean
                                .getFrom()
                                .equalsIgnoreCase("usd"))
                .filter(currencyLayerBean ->
                        currencyLayerBean
                        .getTo()
                        .equalsIgnoreCase("rub"))
                 .toList()
                 .get(0));
        Mockito.when(environment.getProperty("local.server.port")).thenReturn("8081");
        ExchangeData currencyLayerBeanExpected = exchangeDataService.findByFromAndTo("USD","RUB");
        Assertions.assertSame(currencyLayerBeanExpected.getFrom(), rep.findByFromAndTo("USD", "RUB").getFrom());
        Assertions.assertSame(currencyLayerBeanExpected.getTo(), rep.findByFromAndTo("USD", "RUB").getTo());
        Assertions.assertSame(currencyLayerBeanExpected.getConversionIndex(), rep.findByFromAndTo("USD", "RUB").getConversionIndex());
    }
    @Test
    void reStoreData() {
      CurrencyLayerBean currencyLayerBean1 = new CurrencyLayerBean( "USD", "RUB", BigDecimal.ONE);
      CurrencyLayerBean currencyLayerBean2 = new CurrencyLayerBean( "USD", "RUB", BigDecimal.ONE);
      CurrencyLayerBean currencyLayerBean3 = new CurrencyLayerBean( "USD", "RUB", BigDecimal.ONE);
      CurrencyLayerBean currencyLayerBean4 = new CurrencyLayerBean( "USD", "RUB", BigDecimal.ONE);
      ExchangeData currencyLayerBean5 = new ExchangeData(1L, "USD", "RUB", BigDecimal.ONE, 1);
      Mockito.when(currencyLayerApi.currencyData("live")).thenReturn(List.of(currencyLayerBean1, currencyLayerBean2, currencyLayerBean3,currencyLayerBean4));
      exchangeDataService.reStoreData();
      verify(rep).deleteAll();
      verify(currencyLayerApi, times(1)).currencyData("live");

    }
}
