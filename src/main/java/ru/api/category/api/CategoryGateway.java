package ru.api.category.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.category.dto.CategoryDto;

import java.util.List;

public interface CategoryGateway {

    @GetMapping("/all")
    List<CategoryDto> getManufacturerList();

    @GetMapping("/{categoryId}")
    ResponseEntity<CategoryDto> getManufacturer(@PathVariable(name = "categoryId") Long id);

    @PostMapping
    ResponseEntity<CategoryDto> addManufacturer(@Validated @RequestBody CategoryDto categoryDto);

    @PutMapping("/{categoryId}")
    ResponseEntity<CategoryDto> updateManufacturer(@PathVariable(name = "categoryId") Long id,
                                                @Validated @RequestBody CategoryDto categoryDto);

    @DeleteMapping("/{categoryId}")
    void deleteById(@PathVariable(name = "categoryId") Long id);
}