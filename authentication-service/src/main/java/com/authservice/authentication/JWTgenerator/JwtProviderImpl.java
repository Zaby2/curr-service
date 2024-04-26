package com.authservice.authentication.JWTgenerator;

import com.authservice.authentication.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Configuration
public class JwtProviderImpl implements JwtProvider {
    @Override
    public String generateAccessToken(@NonNull UserDTO userDTO) {
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.plusDays(1).atZone(ZoneId.systemDefault()).toInstant();
        Date expDate = Date.from(instant);
        return Jwts.builder()
                .setSubject(userDTO.getUserName())
                .setExpiration(expDate)
                .compact(); // need to refactor cause all this methods are marked as deprecated
    }
}
