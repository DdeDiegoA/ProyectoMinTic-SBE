package com.example.sbemintic.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private String id;
    private String seudonimo;
    private String email;
    private RoleResponseDto role;
}
