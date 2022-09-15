package com.example.sbemintic.services.implementation;

import com.example.sbemintic.db.entities.Role;
import com.example.sbemintic.db.entities.User;
import com.example.sbemintic.db.repositories.RoleRepository;
import com.example.sbemintic.db.repositories.UserRepository;
import com.example.sbemintic.dtos.response.RoleResponseDto;
import com.example.sbemintic.dtos.response.UserResponseDto;
import com.example.sbemintic.exception.Exception;
import com.example.sbemintic.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserResponseDto login(String email, String password) {
        User user= userRepo.findOneByEmail(email).map(x->x).orElseThrow(() -> new Exception("Usuario no encotnrado",404,new Date()));
        if(!encoder.matches(password, user.getPassword())) throw new Exception("Contraseña Invalida",401,new Date());
        Role role= roleRepo.findById(user.getRoleId()).get();
        return UserResponseDto.builder()
                .role(RoleResponseDto.builder()
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .email(user.getEmail())
                .id(user.get_id())
                .seudonimo(user.getSeudonimo())
                .build();
    }
}
