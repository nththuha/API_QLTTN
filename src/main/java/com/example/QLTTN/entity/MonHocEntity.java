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
@Table(name="MONHOC")
public class MonHocEntity {
    @Id
    @Column(name = "MAMH")
    @Nationalized
    private String maMonHoc;

    @Column(name = "TENMH")
    @Nationalized
    private String tenMonHoc;

    @OneToMany(mappedBy = "monHoc", fetch = FetchType.EAGER)
    private List<CauHoiEntity> cauHoi = new ArrayList<>();

    @OneToMany(mappedBy = "monHoc", fetch = FetchType.EAGER)
    private List<ChiTietThiEntity> chiTietThi = new ArrayList<>();

}
