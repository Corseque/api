package ru.api.product.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.product.dto.ProductDto;

import java.util.List;

public interface ProductGateway {

    @GetMapping("/all")
    List<ProductDto> getProductsList();
    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProduct(@PathVariable(name = "productId") Long id);

    @PostMapping
    ResponseEntity<ProductDto> addProduct(@Validated @RequestBody ProductDto productDto);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "productId") Long id,
                                           @Validated @RequestBody ProductDto productDto);

    @DeleteMapping("/{productId}")
    void deleteById(@PathVariable(name = "productId") Long id);
}
