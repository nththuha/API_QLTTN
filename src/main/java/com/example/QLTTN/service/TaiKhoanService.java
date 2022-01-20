package com.example.QLTTN.service;

import com.example.QLTTN.dto.TaiKhoanDTO;

import java.util.List;

public interface TaiKhoanService {
    public List<TaiKhoanDTO> getTaiKhoanTheoLoai(String loai, String ten);
    public List<TaiKhoanDTO> getDSTaiKhoan();
    public void xoaTaiKhoan(String maTaiKhoan);
    public TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public TaiKhoanDTO kiemTraDangNhap(TaiKhoanDTO taiKhoanDTO);
    public TaiKhoanDTO layTaiKhoan(String maTaiKhoan);
}
