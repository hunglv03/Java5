package com.example.java5.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Integer id;
    String name;
    double price;
    int qty = 1;

}
