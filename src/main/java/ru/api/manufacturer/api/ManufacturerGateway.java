package ru.api.manufacturer.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.manufacturer.dto.ManufacturerDto;

import java.util.List;

public interface ManufacturerGateway {
    @GetMapping("/all")
    List<ManufacturerDto> getManufacturerList();

    @GetMapping("/{manufacturerId}")
    ResponseEntity<ManufacturerDto> getManufacturer(@PathVariable(name = "manufacturerId") Long id);


    @PostMapping
    ResponseEntity<ManufacturerDto> addManufacturer(@Validated @RequestBody ManufacturerDto manufacturerDto);

    @PutMapping("/{manufacturerId}")
    ResponseEntity<ManufacturerDto> updateManufacturer(@PathVariable(name = "manufacturerId") Long id,
                                                @Validated @RequestBody ManufacturerDto manufacturerDto);

    @DeleteMapping("/{manufacturerId}")
    void deleteById(@PathVariable(name = "manufacturerId") Long id);
}
