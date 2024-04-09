package com.microservice.example.forex.springbootmicroserviceforexservice;

import com.microservice.example.forex.springbootmicroserviceforexservice.feign.CurrencyLayerApi;
import com.microservice.example.forex.springbootmicroserviceforexservice.feign.layerResponse.CurrencyLayerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ExchangeDataService {

    @Autowired
    private ExchangeDataRepository rep;

    @Autowired
    Environment environment;

    @Autowired
    CurrencyLayerApi currencyLayerApi;


    @Scheduled(fixedRate = 130000)
    protected void reStoreData() {
        rep.deleteAll();
       List<CurrencyLayerBean> result =  currencyLayerApi.currencyData("live");
        for (CurrencyLayerBean currencyLayerBean : result) {
            ExchangeData exchangeData = new ExchangeData();
            exchangeData.setFrom(currencyLayerBean.getFrom());
            exchangeData.setTo(currencyLayerBean.getTo());
            exchangeData.setConversionIndex(currencyLayerBean.getConversionIndex());
            rep.save(exchangeData);
        }
    }

    public ExchangeData findByFromAndTo(String curFrom, String curTO) {
        //reStoreData();
        ExchangeData exD = rep.findByFromAndTo(curFrom, curTO);
        exD.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exD;
    }

}
