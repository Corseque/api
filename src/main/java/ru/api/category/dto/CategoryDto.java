package ru.api.category.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String status;
//
//    private Set<String> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, status);
    }
}
