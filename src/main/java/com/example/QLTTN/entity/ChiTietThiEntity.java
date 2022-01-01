package com.example.QLTTN.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CHITIETTHI")
public class ChiTietThiEntity {
    @Id
    @Column(name = "IDCTT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTT;

    @Column(name = "NGAYTHI")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayThi;

    @Column(name = "DIEM")
    private double diem;

    @ManyToOne
    @JoinColumn(name = "MASV")
    private TaiKhoanEntity taiKhoan_CTT;

    @ManyToOne
    @JoinColumn(name = "MAMH")
    private MonHocEntity monHoc;

}
