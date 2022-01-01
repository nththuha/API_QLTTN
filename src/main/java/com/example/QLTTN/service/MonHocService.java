package com.example.QLTTN.service;

import com.example.QLTTN.dto.MonHocDTO;

import java.util.List;

public interface MonHocService {
    public List<MonHocDTO> getDSMonHoc();
    public void xoaMonHoc(String maMonHoc);
    public MonHocDTO themMonHoc(MonHocDTO monHocDTO);
    public MonHocDTO suaMonhoc(MonHocDTO monHocDTO);
    public MonHocDTO layMonHoc(String maMonHoc);
}
