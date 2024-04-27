package com.authservice.authentication.controller;


import com.authservice.authentication.dto.UserDTO;
import com.authservice.authentication.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class AuthController {

    @Autowired
    AuthService authService;
    @GetMapping("/login")
    public String userLogin(@CookieValue(name="auth_token", defaultValue = "") String token, HttpServletResponse response)
    {
        if(token.isEmpty()) {
            return "no";
        }
        return "yes";
    }
    @PostMapping("/register")
    public void userRegistration(@RequestBody UserDTO userDTO, HttpServletResponse response)
    {
        authService.registerUser(userDTO, response);
    }
}
