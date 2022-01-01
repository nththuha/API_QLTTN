package com.example.QLTTN.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CAUHOI")
public class CauHoiEntity {
    @Id
    @Column(name = "IDCH")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCH;

    @Column(name = "NOIDUNG")
    @Nationalized
    private String noiDung;

    @Column(name = "A")
    @Nationalized
    private String a;

    @Column(name = "B")
    @Nationalized
    private String b;

    @Column(name = "C")
    @Nationalized
    private String c;

    @Column(name = "D")
    @Nationalized
    private String d;

    @Column(name = "DAPAN")
    @Nationalized
    private String dapAn;

    @Column(name = "LUACHON")
    @Nationalized
    private String luaChon;

    @ManyToOne
    @JoinColumn(name = "MAGV")
    private TaiKhoanEntity taiKhoan_CH;

    @ManyToOne
    @JoinColumn(name = "MAMH")
    private MonHocEntity monHoc;
}
