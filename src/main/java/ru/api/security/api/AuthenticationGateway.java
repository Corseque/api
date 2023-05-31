package ru.api.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.api.security.dto.AuthenticationUserDto;

public interface AuthenticationGateway {
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthenticationUserDto authenticationUserDto);
}
