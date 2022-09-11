package com.example.sbemintic.dtos.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {
    @Email()
    private String email;
    @Size(min = 8)
    @NotNull()
    private String password;
}
