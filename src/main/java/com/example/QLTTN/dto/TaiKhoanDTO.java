package com.example.QLTTN.dto;

import com.example.QLTTN.entity.CauHoiEntity;
import com.example.QLTTN.entity.TaiKhoanEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDTO {
    @NotBlank(message = "Mã tài khoản không được để trống")
    private String maTaiKhoan;

    @NotBlank(message = "Họ không được để trống")
    private String ho;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Email không được để trống")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;

    private String loai;

    private List<CauHoiDTO> cauHoi = new ArrayList<>();

    private List<ChiTietThiDTO> chiTietThi = new ArrayList<>();

    public TaiKhoanDTO(TaiKhoanEntity taiKhoanEntity) {
        this.maTaiKhoan = taiKhoanEntity.getMaTaiKhoan();
        this.ho = taiKhoanEntity.getHo();
        this.ten = taiKhoanEntity.getTen();
        this.email = taiKhoanEntity.getEmail();
        this.matKhau = taiKhoanEntity.getMatKhau();
        this.loai = taiKhoanEntity.getLoai();
        this.cauHoi = taiKhoanEntity.getCauHoi().stream().map(CauHoiDTO::new).collect(Collectors.toList());
        this.chiTietThi = taiKhoanEntity.getChiTietThi().stream().map(ChiTietThiDTO::new).collect(Collectors.toList());
    }

    public TaiKhoanEntity toEntity(){
        TaiKhoanEntity taiKhoanEntity = new TaiKhoanEntity();
        taiKhoanEntity.setMaTaiKhoan(this.maTaiKhoan);
        taiKhoanEntity.setHo(this.ho);
        taiKhoanEntity.setTen(this.ten);
        taiKhoanEntity.setEmail(this.email);
        taiKhoanEntity.setLoai(this.loai);
        taiKhoanEntity.setMatKhau(this.matKhau);
        return taiKhoanEntity;
    }
}
