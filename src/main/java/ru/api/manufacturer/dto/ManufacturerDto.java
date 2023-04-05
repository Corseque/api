package ru.api.manufacturer.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private String status;
//
//    private Set<String> products;

}
