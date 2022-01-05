package com.example.QLTTN.dto;

import com.example.QLTTN.entity.CauHoiEntity;
import com.example.QLTTN.entity.MonHocEntity;
import com.example.QLTTN.entity.TaiKhoanEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CauHoiDTO {
    private int idCH;

    @NotBlank(message = "Nội dung không được để trống")
    private String noiDung;

    @NotBlank(message = "Lựa chọn A không được để trống")
    private String a;

    @NotBlank(message = "Lựa chọn B không được để trống")
    private String b;

    @NotBlank(message = "Lựa chọn C không được để trống")
    private String c;

    @NotBlank(message = "Lựa chọn D không được để trống")
    private String d;

    @NotBlank(message = "Đáp án không được để trống")
    private String dapAn;

    private String luaChon;

    private String maTaiKhoan;

    private String maMonHoc;

    public CauHoiDTO (CauHoiEntity cauHoiEntity){
        this.idCH = cauHoiEntity.getIdCH();
        this.a = cauHoiEntity.getA();
        this.b = cauHoiEntity.getB();
        this.c = cauHoiEntity.getC();
        this.d = cauHoiEntity.getD();
        this.noiDung = cauHoiEntity.getNoiDung();
        this.luaChon = cauHoiEntity.getLuaChon();
        this.dapAn = cauHoiEntity.getDapAn();
        this.maTaiKhoan = cauHoiEntity.getTaiKhoan_CH().getMaTaiKhoan();
        this.maMonHoc = cauHoiEntity.getMonHoc().getMaMonHoc();
    }

    public CauHoiEntity toEntity(){
        CauHoiEntity cauHoiEntity = new CauHoiEntity();
        if(idCH != 0) {
            cauHoiEntity.setIdCH(this.idCH);
        }
        cauHoiEntity.setA(this.a);
        cauHoiEntity.setB(this.b);
        cauHoiEntity.setC(this.c);
        cauHoiEntity.setD(this.d);
        cauHoiEntity.setNoiDung(this.noiDung);
        cauHoiEntity.setDapAn(this.dapAn);
        //cauHoiEntity.setTaiKhoan_CH(this.getTaiKhoan_CH());
        //cauHoiEntity.setMonHoc(this.monHoc);
        return cauHoiEntity;
    }
}
