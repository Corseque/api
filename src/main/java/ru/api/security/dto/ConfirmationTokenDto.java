package ru.api.security.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConfirmationTokenDto {
    @NotNull
    @Size(min = 36, max = 36, message = "Confirmation code length must be 36 numbers length")
    private String token;
}
