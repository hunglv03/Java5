package com.example.java5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HangKhachHang")
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer maHang;
    private String tenHang;
    private String moTa;
    private Integer diemToiThieu;
    private Integer trangThai;
}
