package com.example.java5.model;

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
    String fullName;
    Boolean gender;
    String email;
    Double salary;
    String position;
}
