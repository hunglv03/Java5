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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long maKhachHang;
    private String tenKhachHang;
    private Date sinhNhat;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private Boolean gioiTinh;
    private String chungMinhThu;
    private String soCanCuoc;
    private String anhDaiDien;
    private Integer trangThai;
    private Integer diemTichLuy;

    @ManyToOne
    @JoinColumn(name = "hangkhachhang")
    HangKhachHang hangKhachHang;

    @OneToOne(mappedBy = "nguoiSoHuu")
    TheThanhVien theThanhVien;

}
