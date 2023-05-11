package ru.api.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.api.security.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldMatch(firstFieldName = "password", secondFieldName = "matchingPassword",
        message = "The password must match")
public class UserDto {

    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 3, message = "username length must be grater than 3 letters")
    private String username;

    @NotBlank
    @Size(min = 8, message = "password length must be grater than 8 letters")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 8, message = "password length must be grater than 8 letters")
    private String matchingPassword;

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
