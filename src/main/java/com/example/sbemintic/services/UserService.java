package com.example.sbemintic.services;

import com.example.sbemintic.dtos.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
}
