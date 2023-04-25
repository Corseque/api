package ru.api.security.api;

import org.springframework.http.ResponseEntity;
import org.mapstruct.Context;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.api.security.AuthenticationUserDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationGateway {
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthenticationUserDto authenticationUserDto, @Context HttpServletRequest request);
}
