package com.example.sbemintic.services.implementation;

import com.example.sbemintic.db.entities.Role;
import com.example.sbemintic.db.entities.User;
import com.example.sbemintic.db.repositories.RoleRepository;
import com.example.sbemintic.db.repositories.UserRepository;
import com.example.sbemintic.dtos.request.CreateUserRequestDto;
import com.example.sbemintic.dtos.request.UpdateUserRequestDto;
import com.example.sbemintic.dtos.response.CreateUserResponseDto;
import com.example.sbemintic.dtos.response.RoleResponseDto;
import com.example.sbemintic.dtos.response.UserResponseDto;
import com.example.sbemintic.exception.Exception;
import com.example.sbemintic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public CreateUserResponseDto create(CreateUserRequestDto user) {

        User userToCreate = User.builder()
                .email(user.getEmail())
                .firstName(user.getName())
                .lastName(user.getLastName())
                .password(encoder.encode(user.getPassword()))
                .roleId(roleRepo.findOneByName("Estudiante").get().get_id())
                .build();
        userToCreate = repo.save(userToCreate);
        return CreateUserResponseDto.builder()
                .id(userToCreate.get_id())
                .build();
    }

    @Override
    public void delete(String id) {
        repo.findById(id).map(x -> {
            repo.delete(x);
            return null;
        }).orElseThrow(() -> new Exception("Usuario no existe", 404, new Date()));
    }

    @Override
    public void update(UpdateUserRequestDto user, String id) {
        User userFound =  repo.findById(id).map(x -> {
            return x;
        }).orElseThrow(() -> new Exception("Usuario no existe", 404, new Date()));
        user.setSeudonimo(user.getSeudonimo() != null ? user.getSeudonimo() : userFound.getSeudonimo());
        repo.save(userFound);
    }

    @Override
    public UserResponseDto getById(String id) {
        User user = repo.findById(id).map(x -> {
            return x;
        }).orElseThrow(() -> new Exception("Usuario no existe", 404, new Date()));

        Role role = roleRepo.findById(user.getRoleId()).get();

        return UserResponseDto.builder()
                .role(RoleResponseDto.builder()
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .email(user.getEmail())
                .id(user.get_id())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .build();
    }

    @Override
    public List<UserResponseDto> getUsers(String role) {
        Role r = roleRepo.findOneByName(role).get();
        List<User> users = repo.findAllByRoleId(r.get_id());

        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user: users) {
            usersToReturn.add(
                    UserResponseDto.builder()
                            .role(RoleResponseDto.builder()
                                    .name(r.getName())
                                    .description(r.getDescription())
                                    .build())
                            .email(user.getEmail())
                            .id(user.get_id())
                            .fullName(user.getFirstName() + " " + user.getLastName())
                            .build()
            );
        }
        return usersToReturn;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = repo.findAll();
        Set<String> roleIds = users.stream().map(x -> x.getRoleId()).collect(Collectors.toSet());
        List<Role> roles = (List<Role>) roleRepo.findAllById(roleIds);

        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user: users) {
            Role role = roles.stream().filter(x -> x.get_id().equals(user.getRoleId())).collect(Collectors.toList()).get(0);
            usersToReturn.add(
                    UserResponseDto.builder()
                            .role(RoleResponseDto.builder()
                                    .name(role.getName())
                                    .description(role.getDescription())
                                    .build())
                            .email(user.getEmail())
                            .id(user.get_id())
                            .fullName(user.getFirstName() + " " + user.getLastName())
                            .build()
            );
        }
        return usersToReturn;
    }
}