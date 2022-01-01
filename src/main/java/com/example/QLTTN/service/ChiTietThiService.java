package com.example.QLTTN.service;

import com.example.QLTTN.dto.ChiTietThiDTO;

import java.util.List;

public interface ChiTietThiService {
    public List<ChiTietThiDTO> getDSChiTietThi();
    public List<ChiTietThiDTO> getChiTietThiTheoMon(String maMonHoc);
    public ChiTietThiDTO themChiTietThi(ChiTietThiDTO chiTietThiDTO);
}
