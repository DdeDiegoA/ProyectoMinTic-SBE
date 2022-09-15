package com.example.sbemintic.services;

import com.example.sbemintic.dtos.response.UserResponseDto;

public interface AuthService {
    UserResponseDto login(String email,String password);
}
