package com.authservice.authentication.service;

import com.authservice.authentication.JWTgenerator.JwtProvider;
import com.authservice.authentication.Repository.UserRepository;
import com.authservice.authentication.dto.UserDTO;
import com.authservice.authentication.model.UserL;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserRepository userRepository;

    public String registerUser(@NonNull UserDTO userDTO, HttpServletResponse response) {
        String accessToken = jwtProvider.generateAccessToken(userDTO);
        UserL user = new UserL();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRegisterDate(LocalDateTime.now());
        userRepository.save(user);
        addTokenToCookie(accessToken, response);
        return accessToken;
    }

    @SneakyThrows
    public void addTokenToCookie(@NonNull String token, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("auth_token", token);
        cookie.setMaxAge(7*24*60*60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        httpServletResponse.setContentType("text/plain");
    }
}
