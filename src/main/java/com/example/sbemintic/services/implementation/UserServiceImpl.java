package com.example.sbemintic.services.implementation;

import com.example.sbemintic.db.entities.User;
import com.example.sbemintic.db.repositories.UserRepository;
import com.example.sbemintic.dtos.response.UserResponseDto;
import com.example.sbemintic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = this.repo.findAll();
        return users.stream().map( x -> UserResponseDto.builder()
                    .seudonimo(x.getSeudonimo())
                    .correo(x.getCorreo())
                    .rol(x.getRol())
                    .build()
        ).collect(Collectors.toList());
    }
}
