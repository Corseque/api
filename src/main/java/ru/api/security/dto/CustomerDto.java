//package ru.api.security.dto;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Set;
//
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//public class CustomerDto {
//
//    @JsonIgnore
//    private Long id;
//
//    @NotBlank
//    @Size(min = 3, message = "username length must be grater than 3 letters")
//    private String username;
//
//    @NotBlank
//    private String firstname;
//
//    @NotBlank
//    private String lastname;
//
//    @Email
//    @NotBlank
//    private String email;
//
//    @NotBlank
//    @Size(min = 8)
//    private String phone;
//
//    @NotNull
//    private Set<Long> orderIds;
//}
