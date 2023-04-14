package ru.api.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.security.UserDto;

import java.util.List;

public interface UserGateway {

    @GetMapping("/all")
    List<UserDto> getUserList();

    @GetMapping("/{userId}")
    ResponseEntity<?> getUser(@PathVariable(name = "userId") Long id);

    @PostMapping
    ResponseEntity<?> addUser(@Validated @RequestBody UserDto userDto);

    @PutMapping("/{userId}")
    ResponseEntity<?> updateUser(@PathVariable(name = "userId") Long id,
                                        @Validated @RequestBody UserDto userDto);
    @DeleteMapping("/{userId}")
    void deleteById(@PathVariable(name = "userId") Long id);
}
