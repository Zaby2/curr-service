package com.authservice.authentication.controller;


import com.authservice.authentication.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class AuthController {

    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public void userLogin(@RequestBody String userName,
                          String password, HttpServletResponse response)
    {

    }
}
