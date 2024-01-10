package com.example.java5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TheThanhVien")
public class TheThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String maThe;
    private String mauThe;
    private String loaiThe;
    private Date ngayPhatHanh;
    private Date ngayHuy;
    private Integer trangThai;
    @OneToOne
    @JoinColumn(name = "nguoisohuu")
    KhachHang nguoiSoHuu;
}
