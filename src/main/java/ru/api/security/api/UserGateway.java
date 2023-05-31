package ru.api.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.security.dto.UserDto;

import java.util.List;

public interface UserGateway {

    @GetMapping("/all")
    List<UserDto> getUserList(@RequestHeader("Authorization") String token);

    @GetMapping("/{userId}")
    ResponseEntity<?> getUser(@RequestHeader("Authorization") String token,
                              @PathVariable(name = "userId") Long id);

    @PostMapping("/register")
    ResponseEntity<?> addUser(@Validated @RequestBody UserDto userDto);

    @PutMapping("/{userId}")
    ResponseEntity<?> updateUser(@RequestHeader("Authorization") String token,
                                 @PathVariable(name = "userId") Long id,
                                 @Validated @RequestBody UserDto userDto);
    @DeleteMapping("/{userId}")
    void deleteById(@RequestHeader("Authorization") String token,
                    @PathVariable(name = "userId") Long id);
}
