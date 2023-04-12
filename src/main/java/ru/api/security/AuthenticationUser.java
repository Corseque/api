package ru.api.security;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
