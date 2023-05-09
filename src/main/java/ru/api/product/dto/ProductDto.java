package ru.api.product.dto;

import lombok.*;
import ru.api.category.dto.CategoryDto;
import ru.api.manufacturer.dto.ManufacturerDto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    static final long serialVersionUID = -6405971368848558070L;

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

    @Override
    public String toString() {
        StringBuilder product = new StringBuilder("ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", old_cost=" + old_cost +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", manufacturer=" + manufacturer.getName() +
                ", categories=");
        for (CategoryDto category: categories) {
            product.append(category.getTitle()).append(", ");
        }
        product.delete(product.length() - 3, product.length() - 1);
        product.append("}");
        return product.toString();
    }


}
