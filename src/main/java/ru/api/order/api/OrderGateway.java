package ru.api.order.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.api.order.dto.OrderDto;

import java.util.List;

public interface OrderGateway {

    @GetMapping("/all")
    List<OrderDto> getOrdersList(@RequestHeader("Authorization") String token);
    @GetMapping("/{orderId}")
    ResponseEntity<OrderDto> getOrder(@RequestHeader("Authorization") String token,
                                          @PathVariable(name = "orderId") Long id);

    @PostMapping
    ResponseEntity<OrderDto> addOrder(@RequestHeader("Authorization") String token,
                                          @Validated @RequestBody OrderDto orderDto);

    @PutMapping("/{orderId}")
    ResponseEntity<OrderDto> updateOrder(@RequestHeader("Authorization") String token,
                                             @PathVariable(name = "orderId") Long id,
                                             @Validated @RequestBody OrderDto orderDto);

    @DeleteMapping("/{orderId}")
    void deleteById(@RequestHeader("Authorization") String token,
                    @PathVariable(name = "orderId") Long id);
}
