package com.example.QLTTN.service.Impl;

import com.example.QLTTN.dto.CauHoiDTO;
import com.example.QLTTN.dto.TaiKhoanDTO;
import com.example.QLTTN.entity.CauHoiEntity;
import com.example.QLTTN.entity.MonHocEntity;
import com.example.QLTTN.entity.TaiKhoanEntity;
import com.example.QLTTN.exception.NotFoundException;
import com.example.QLTTN.repository.CauHoiRepository;
import com.example.QLTTN.repository.MonHocRepository;
import com.example.QLTTN.repository.TaiKhoanRepository;
import com.example.QLTTN.service.CauHoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CauHoiServiceImpl implements CauHoiService {
    @Autowired
    CauHoiRepository cauHoiRepository;

    @Autowired
    MonHocRepository monHocRepository;

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    int soLuong = 10;

    @Override
    public List<CauHoiDTO> getDSCauHoi() {
        List<CauHoiEntity> DSCauHoi = cauHoiRepository.findAll();
        return DSCauHoi.stream().map(CauHoiDTO::new).collect(Collectors.toList());
    }

    public List<CauHoiEntity> layDSNgauNhien(List<CauHoiEntity> DSCauHoi) {
        Collections.shuffle(DSCauHoi);
        List<CauHoiEntity> list = DSCauHoi.subList(0, soLuong);
        return list;
    }

    @Override
    public List<CauHoiDTO> getDSNgauNhienCauHoi(String maMonHoc) {
        List<CauHoiEntity> DSCauHoi = cauHoiRepository.findByMonHoc_MaMonHoc(maMonHoc);
        List<CauHoiEntity> DSNgauNhien = new ArrayList<>();
        if(DSCauHoi.size() < soLuong){
            //////////////////////////////////////////////////////////////////////
        }
        else DSNgauNhien = layDSNgauNhien(DSCauHoi);
        return DSNgauNhien.stream().map(CauHoiDTO::new).collect(Collectors.toList());
    }

    @Override
    public void xoaCauHoi(Integer idCH) {
        cauHoiRepository.deleteById(idCH);
    }

    @Override
    public List<CauHoiDTO> getDSCauHoiTheoMon(String maMonHoc) {
        List<CauHoiEntity> DSCauHoi = cauHoiRepository.findByMonHoc_MaMonHoc(maMonHoc);
        return DSCauHoi.stream().map(CauHoiDTO::new).collect(Collectors.toList());
    }

    @Override
    public CauHoiDTO themCauHoi(CauHoiDTO cauHoiDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.getById(cauHoiDTO.getMaTaiKhoan());
        MonHocEntity monHocEntity = monHocRepository.getById(cauHoiDTO.getMaMonHoc());
        CauHoiEntity cauHoiTemp = cauHoiDTO.toEntity();
        cauHoiTemp.setTaiKhoan_CH(taiKhoanEntity);
        cauHoiTemp.setMonHoc(monHocEntity);
        CauHoiEntity saveCauHoiOTD = cauHoiRepository.save(cauHoiTemp);
        return new CauHoiDTO(saveCauHoiOTD);
    }

    @Override
    public CauHoiDTO suaCauHoi(CauHoiDTO cauHoiDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.getById(cauHoiDTO.getMaTaiKhoan());
        MonHocEntity monHocEntity = monHocRepository.getById(cauHoiDTO.getMaMonHoc());
        CauHoiEntity cauHoiEntity = cauHoiRepository.findById(cauHoiDTO.getIdCH()).orElseThrow(() -> new NotFoundException("Câu hỏi " + cauHoiDTO.getIdCH() + " không tồn tại!"));
        cauHoiEntity.setA(cauHoiDTO.getA());
        cauHoiEntity.setB(cauHoiDTO.getB());
        cauHoiEntity.setC(cauHoiDTO.getC());
        cauHoiEntity.setD(cauHoiDTO.getD());
        cauHoiEntity.setDapAn(cauHoiDTO.getDapAn());
        cauHoiEntity.setNoiDung(cauHoiDTO.getNoiDung());
        cauHoiEntity.setMonHoc(monHocEntity);
        cauHoiEntity.setTaiKhoan_CH(taiKhoanEntity);
        CauHoiEntity saveCauHoiDTO = cauHoiRepository.save(cauHoiEntity);
        return new CauHoiDTO(saveCauHoiDTO);
    }

    @Override
    public CauHoiDTO layCauHoi(Integer idCH) {
        CauHoiEntity cauHoiEntity = cauHoiRepository.findById(idCH).orElseThrow(() -> new NotFoundException("Câu hỏi " + idCH + " không tồn tại!"));
        return new CauHoiDTO(cauHoiEntity);
    }
}
