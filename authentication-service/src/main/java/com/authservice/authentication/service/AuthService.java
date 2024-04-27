package com.authservice.authentication.service;


import com.authservice.authentication.dto.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;


public interface AuthService {
    public String registerUser(@NonNull UserDTO userDTO, HttpServletResponse httpServletResponse );
    public void addTokenToCookie(@NonNull String token, HttpServletResponse httpServletResponse);
}
