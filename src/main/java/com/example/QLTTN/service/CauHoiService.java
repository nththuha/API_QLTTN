package com.example.QLTTN.service;

import com.example.QLTTN.dto.CauHoiDTO;

import java.util.List;

public interface CauHoiService {
    public List<CauHoiDTO> getDSCauHoi();
    public void xoaCauHoi(Integer idCH);
    public List<CauHoiDTO> getDSCauHoiTheoMon(String maMonHoc);
    public List<CauHoiDTO> getDSNgauNhienCauHoi(String maMonHoc);
    public CauHoiDTO themCauHoi(CauHoiDTO cauHoiDTO);
    public CauHoiDTO suaCauHoi(CauHoiDTO cauHoiDTO);
    public CauHoiDTO layCauHoi(Integer idCH);
}
