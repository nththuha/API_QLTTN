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

    private String maTaiKhoan;

    private String hoTen;

    private String maMonHoc;

    private String tenMonHoc;

    public ChiTietThiDTO (ChiTietThiEntity chiTietThiEntity){
        this.idCTT = chiTietThiEntity.getIdCTT();
        this.diem = chiTietThiEntity.getDiem();
        this.ngayThi = chiTietThiEntity.getNgayThi();
        this.maMonHoc = chiTietThiEntity.getMonHoc().getMaMonHoc();
        this.maTaiKhoan = chiTietThiEntity.getTaiKhoan_CTT().getMaTaiKhoan();
        this.hoTen = chiTietThiEntity.getTaiKhoan_CTT().getHo() + " " + chiTietThiEntity.getTaiKhoan_CTT().getTen();
        this.tenMonHoc = chiTietThiEntity.getMonHoc().getTenMonHoc();
    }

    public ChiTietThiEntity toEntity(){
        ChiTietThiEntity chiTietThiEntity = new ChiTietThiEntity();
        if(this.idCTT != 0){
            chiTietThiEntity.setIdCTT(this.idCTT);
        }
        chiTietThiEntity.setNgayThi(this.ngayThi);
        chiTietThiEntity.setDiem(this.diem);
        return chiTietThiEntity;
    }
}
