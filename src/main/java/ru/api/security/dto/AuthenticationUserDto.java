package ru.api.security.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticationUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
