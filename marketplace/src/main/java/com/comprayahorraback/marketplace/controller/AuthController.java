package com.comprayahorraback.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.dto_request.AuthRequest;
import com.comprayahorraback.marketplace.dto_request.RegisterRequest;
import com.comprayahorraback.marketplace.dto_response.AuthResponse;
import com.comprayahorraback.marketplace.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController{

        private final AuthService authService;


        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

            if(!authService.usernameAlreadyExists(registerRequest)){

                AuthResponse authResponse = authService.register(registerRequest);
                if(authResponse != null){
                    return new ResponseEntity<>("User created!", HttpStatus.CREATED);
                }
                else{
                    return new ResponseEntity<>("user not created...", HttpStatus.BAD_REQUEST);
                }

            } else{

                return new ResponseEntity<>("Error! the username already exists.", HttpStatus.BAD_REQUEST);
            }


        }
        
        
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){

            AuthResponse authResponse = authService.login(authRequest);
            if(authResponse == null){
                return new ResponseEntity<>("Invalid credentials!", HttpStatus.BAD_REQUEST);
            }
    
            return ResponseEntity.ok(authService.login(authRequest));
        }
}
