package ru.api.order.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.api.address.dto.AddressDto;
import ru.api.order_item.dto.OrderItemDto;
//import ru.api.security.dto.CustomerDto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;

    @NotBlank
    private String recipientFirstname;

    @NotBlank
    private String recipientLastname;

    @NotBlank
    private String recipientPhone;

    @NotBlank
    private String recipientMail;

    @NotBlank
    private String status;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @NotNull//????
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal deliveryPrice;

    private AddressDto deliveryAddress; //todo перевести в Dto или String?

//    private Address shopAddress; //todo перевести в Dto или String?

//    @NotNull//????
//    private CustomerDto customer; //    private AccountUser accountUser; //todo сделать еще один userDto с хранением инфо о заказе

    @NotNull
    private String accountUsername;

    @NotNull//????
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    private List<OrderItemDto> orderItems;



}
