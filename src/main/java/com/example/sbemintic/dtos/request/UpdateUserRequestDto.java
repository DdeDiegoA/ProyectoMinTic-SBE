package com.example.sbemintic.dtos.request;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequestDto {

    @Size(min = 2, message = "Nombre incorrecto")
    private String seudonimo;
    @Size(min = 2, message = "Incorrecto")
    private String roleId;
}
