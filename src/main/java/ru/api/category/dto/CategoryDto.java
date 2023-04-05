package ru.api.category.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private String status;
//
//    private Set<String> products;

}
