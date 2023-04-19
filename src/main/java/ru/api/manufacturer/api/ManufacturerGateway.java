package ru.api.manufacturer.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.manufacturer.dto.ManufacturerDto;

import java.util.List;

public interface ManufacturerGateway {
    @GetMapping("/all")
    List<ManufacturerDto> getManufacturerList(@RequestHeader("Authorization") String token);

    @GetMapping("/{manufacturerId}")
    ResponseEntity<ManufacturerDto> getManufacturer(@RequestHeader("Authorization") String token,
                                                    @PathVariable(name = "manufacturerId") Long id);


    @PostMapping
    ResponseEntity<ManufacturerDto> addManufacturer(@RequestHeader("Authorization") String token,
                                                    @Validated @RequestBody ManufacturerDto manufacturerDto);

    @PutMapping("/{manufacturerId}")
    ResponseEntity<ManufacturerDto> updateManufacturer(@RequestHeader("Authorization") String token,
                                                       @PathVariable(name = "manufacturerId") Long id,
                                                       @Validated @RequestBody ManufacturerDto manufacturerDto);

    @DeleteMapping("/{manufacturerId}")
    void deleteById(@RequestHeader("Authorization") String token,
                    @PathVariable(name = "manufacturerId") Long id);
}
