package com.demo.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.AuthRequest;
import com.demo.security.CustomUserDetailsService;
import com.demo.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailsService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

//    public AuthController(CustomUserDetailsService userService,
//                          JwtUtil jwtUtil,
//                          AuthenticationManager authenticationManager) {
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//        this.authenticationManager = authenticationManager;
//    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        var user = userService.loadUserByUsername(request.getUsername());
        return jwtUtil.generateToken(user);
    }
}
