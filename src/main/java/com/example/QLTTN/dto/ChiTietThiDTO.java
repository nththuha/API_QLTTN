package com.example.QLTTN.dto;

import com.example.QLTTN.entity.ChiTietThiEntity;
import com.example.QLTTN.entity.MonHocEntity;
import com.example.QLTTN.entity.TaiKhoanEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietThiDTO {
    private int idCTT;

    private Date ngayThi;

    private double diem;

    private TaiKhoanEntity taiKhoan_CTT = new TaiKhoanEntity();

    private MonHocEntity monHoc = new MonHocEntity();

    public ChiTietThiDTO (ChiTietThiEntity chiTietThiEntity){
        this.idCTT = chiTietThiEntity.getIdCTT();
        this.diem = chiTietThiEntity.getDiem();
        this.ngayThi = chiTietThiEntity.getNgayThi();
        this.monHoc = chiTietThiEntity.getMonHoc();
        this.taiKhoan_CTT = chiTietThiEntity.getTaiKhoan_CTT();
    }

    public ChiTietThiEntity toEntity(){
        ChiTietThiEntity chiTietThiEntity = new ChiTietThiEntity();
        if(this.idCTT != 0){
            chiTietThiEntity.setIdCTT(this.idCTT);
        }
        chiTietThiEntity.setNgayThi(this.ngayThi);
        chiTietThiEntity.setDiem(this.diem);
        chiTietThiEntity.setMonHoc(this.monHoc);
        chiTietThiEntity.setTaiKhoan_CTT(this.taiKhoan_CTT);
        return chiTietThiEntity;
    }
}
