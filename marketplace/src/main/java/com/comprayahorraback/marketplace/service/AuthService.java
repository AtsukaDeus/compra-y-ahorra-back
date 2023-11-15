package com.comprayahorraback.marketplace.service;

import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.AuthRequest;
import com.comprayahorraback.marketplace.dto_request.RegisterRequest;
import com.comprayahorraback.marketplace.dto_response.AuthResponse;
import com.comprayahorraback.marketplace.dto_response.UsercaResponse;
import com.comprayahorraback.marketplace.entity.Role;
import com.comprayahorraback.marketplace.entity.Userca;
import com.comprayahorraback.marketplace.mappers.UsercaMapper;
import com.comprayahorraback.marketplace.repository.UsercaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UsercaRepository usercaRepository;
    private final JwtService jwtService;


    public AuthResponse register(RegisterRequest registerRequest){

        Userca userca = Userca.builder()
            .run(registerRequest.getRun())
            .name(registerRequest.getName())
            .password(registerRequest.getPassword())
            .role(Role.ROLE_ADMIN) // ROLE_CLIENT or ROLE_ADMIN
            .email(registerRequest.getEmail())
            .locked(false)
            .build();
        
        usercaRepository.save(userca);
        var jwtToken = jwtService.generateToken(userca);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }



    public AuthResponse login(AuthRequest authRequest){

        var userca = usercaRepository.findByEmail(authRequest.getEmail())
                        .orElseThrow(null);
        
        if(
            userca == null ||
            !(   
                userca.getEmail().equals(authRequest.getEmail()) &&
                userca.getPassword().equals(authRequest.getPassword())
            )
        ) return null;

        if(userca.isAccountNonLocked()){
            var jwtToken = jwtService.generateToken(userca);

            UsercaMapper usercaMapper = new UsercaMapper();
            UsercaResponse usercaResponse = usercaMapper.usercaEntityToResponse(userca);

            return AuthResponse.builder()
                    .token(jwtToken)
                    .usercaResponse(usercaResponse)
                    .build();
        
        } else{
            return null;
        }

    }


    public boolean usernameAlreadyExists(RegisterRequest registerRequest){

        var userFinded = usercaRepository.findByEmail(registerRequest.getEmail())
                        .orElse(null); 

        return userFinded != null;
    }

}
