package ru.api.order_item.dto;

import lombok.*;
import ru.api.order.dto.OrderDto;
import ru.api.product.dto.ProductDto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderItemDto {

    private Long id;

    @NotNull
    private Short quantity;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal itemPrice;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal totalPrice;

    @NotNull
    private ProductDto product;

    @NotNull
    private OrderDto order;
}
