package ru.api.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 3, message = "username length must be grater than 3 letters")
    private String username;

    @NotBlank
    @Size(min = 8, message = "password length must be grater than 8 letters")
    private String password;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String phone;
}
