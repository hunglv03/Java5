package com.example.java5.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Student {
    @NotBlank(message = "{NotBlank.sv.name}")
    String name;
    @NotBlank(message = "{NotBlank.sv.email}")
    @Email(message = "{Email.sv.email}")
    String email;
    @Min(value = 0, message = "{Min.sv.marks}")
    @Max(value = 10, message = "{Max.sv.marks}")
    @NotNull(message = "{NotNull.sv.marks}")
    Double marks;
    @NotNull(message = "{NotNull.sv.gender}")
    Boolean gender;
    @NotBlank(message = "{NotBlank.sv.faculty}")
    String faculty;
    @NotEmpty(message = "{NotEmpty.sv.hobbies}")
    List<String> hobbies;
}
