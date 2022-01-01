package com.example.QLTTN.dto;

import com.example.QLTTN.entity.CauHoiEntity;
import com.example.QLTTN.entity.ChiTietThiEntity;
import com.example.QLTTN.entity.MonHocEntity;
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
public class MonHocDTO {
    @NotBlank(message = "Mã môn học không được để trống")
    private String maMonHoc;

    @NotBlank(message = "Tên môn học không được để trống")
    private String tenMonHoc;

    private List<CauHoiDTO> cauHoi = new ArrayList<>();

    private List<ChiTietThiDTO> chiTietThi = new ArrayList<>();

    public MonHocDTO(MonHocEntity monHocEntity) {
        this.maMonHoc = monHocEntity.getMaMonHoc();
        this.tenMonHoc = monHocEntity.getTenMonHoc();
        this.cauHoi = monHocEntity.getCauHoi().stream().map(CauHoiDTO::new).collect(Collectors.toList());
        this.chiTietThi = monHocEntity.getChiTietThi().stream().map(ChiTietThiDTO::new).collect(Collectors.toList());
    }

    public MonHocEntity toEntity(){
        MonHocEntity monHocEntity = new MonHocEntity();
        monHocEntity.setMaMonHoc(this.maMonHoc);
        monHocEntity.setTenMonHoc(this.tenMonHoc);
        return monHocEntity;
    }
}
