package ru.api.product.dto;

import lombok.*;
import ru.api.category.dto.CategoryDto;
import ru.api.manufacturer.dto.ManufacturerDto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal cost;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal old_cost;

    @PastOrPresent
    private LocalDate date;

    @NotNull
    private String status;

    @NotNull
    private ManufacturerDto manufacturer;

    @NotNull
    private Set<CategoryDto> categories;


}
