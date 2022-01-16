package com.example.QLTTN.controller;

import com.example.QLTTN.dto.TaiKhoanDTO;
import com.example.QLTTN.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dangnhap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DangNhapController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @PostMapping("")
    public TaiKhoanDTO kiemTraDangNhap(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO){
        return taiKhoanService.kiemTraDangNhap(taiKhoanDTO);
    }
}
