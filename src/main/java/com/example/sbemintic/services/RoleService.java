package com.example.sbemintic.services;

import com.example.sbemintic.dtos.response.PermissionResponseDto;
import com.example.sbemintic.dtos.response.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> getAllRoles();
    List<PermissionResponseDto> getAllPermission(String role);
}
