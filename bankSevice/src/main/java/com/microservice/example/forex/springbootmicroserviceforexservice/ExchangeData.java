package com.microservice.example.forex.springbootmicroserviceforexservice;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeData {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="cur_from")
    private String from;
    @Column(name="cur_to")
    private String to;
    private BigDecimal conversionIndex;
    private int port;
}
