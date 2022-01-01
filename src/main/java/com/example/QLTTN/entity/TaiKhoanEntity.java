package com.example.QLTTN.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TAIKHOAN")
public class TaiKhoanEntity {
    @Id
    @Column(name = "MATK")
    @Nationalized
    private String maTaiKhoan;

    @Column(name = "HO")
    @Nationalized
    private String ho;

    @Column(name = "TEN")
    @Nationalized
    private String ten;

    @Column(name = "EMAIL", unique = true)
    @Nationalized
    private String email;

    @Column(name = "MATKHAU")
    @Nationalized
    private String matKhau;

    @Column(name = "LOAI")
    @Nationalized
    private String loai;

    @OneToMany(mappedBy = "taiKhoan_CH", fetch = FetchType.EAGER)
    private List<CauHoiEntity> cauHoi = new ArrayList<>();

    @OneToMany(mappedBy = "taiKhoan_CTT", fetch = FetchType.EAGER)
    private List<ChiTietThiEntity> chiTietThi = new ArrayList<>();
}
