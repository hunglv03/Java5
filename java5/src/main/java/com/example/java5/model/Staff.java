package com.example.java5.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    String id;
    @NotNull
    String fullName;
    Boolean gender;
    String email;
    Double salary;
    String position;
}
