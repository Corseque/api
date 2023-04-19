package ru.api.product.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.product.dto.ProductDto;

import java.util.List;

public interface ProductGateway {

    @GetMapping("/all")
    List<ProductDto> getProductsList(@RequestHeader("Authorization") String token);
    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProduct(@RequestHeader("Authorization") String token,
                                          @PathVariable(name = "productId") Long id);

    @PostMapping
    ResponseEntity<ProductDto> addProduct(@RequestHeader("Authorization") String token,
                                          @Validated @RequestBody ProductDto productDto);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> updateProduct(@RequestHeader("Authorization") String token,
                                             @PathVariable(name = "productId") Long id,
                                             @Validated @RequestBody ProductDto productDto);

    @DeleteMapping("/{productId}")
    void deleteById(@RequestHeader("Authorization") String token,
                    @PathVariable(name = "productId") Long id);
}
