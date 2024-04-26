package com.authservice.authentication.JWTgenerator;

import com.authservice.authentication.dto.UserDTO;
import lombok.NonNull;

public interface JwtProvider {
    public String generateAccessToken(@NonNull UserDTO userDTO);
}
