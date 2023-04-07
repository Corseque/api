package ru.api.category.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.category.dto.CategoryDto;

import java.util.List;

public interface CategoryGateway {

    @GetMapping("/all")
    List<CategoryDto> getCategoryList();

    @GetMapping("/{categoryId}")
    ResponseEntity<CategoryDto> getCategory(@PathVariable(name = "categoryId") Long id);

    @PostMapping
    ResponseEntity<CategoryDto> addCategory(@Validated @RequestBody CategoryDto categoryDto);

    @PutMapping("/{categoryId}")
    ResponseEntity<CategoryDto> updateCategory(@PathVariable(name = "categoryId") Long id,
                                                @Validated @RequestBody CategoryDto categoryDto);

    @DeleteMapping("/{categoryId}")
    void deleteById(@PathVariable(name = "categoryId") Long id);
}
