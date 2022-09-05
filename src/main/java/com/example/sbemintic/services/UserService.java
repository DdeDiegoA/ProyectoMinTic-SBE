package com.example.sbemintic.services;

import com.example.sbemintic.dtos.request.CreateUserRequestDto;
import com.example.sbemintic.dtos.request.UpdateUserRequestDto;
import com.example.sbemintic.dtos.response.CreateUserResponseDto;
import com.example.sbemintic.dtos.response.UserResponseDto;

import java.util.List;

public interface UserService {
    CreateUserResponseDto create(CreateUserRequestDto user);
    void delete(String id);
    void update(UpdateUserRequestDto user, String id);
    UserResponseDto getById(String id);
    List<UserResponseDto> getUsers(String role);
    List<UserResponseDto> getUsers();
}