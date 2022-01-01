package com.example.QLTTN.controller;

import com.example.QLTTN.dto.TaiKhoanDTO;
import com.example.QLTTN.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/taikhoan")
    public List<TaiKhoanDTO> layDSTheoLoai(@RequestParam(value = "loai")String loai){
        return taiKhoanService.getTaiKhoanTheoLoai(loai);
    }

    @GetMapping("/taikhoan/{maTaiKhoan}")
    public TaiKhoanDTO layTaiKhoan(@PathVariable String maTaiKhoan){
        return taiKhoanService.layTaiKhoan(maTaiKhoan);
    }

    @PostMapping("/taikhoan")
    public TaiKhoanDTO themTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }

    @PutMapping("/taikhoan")
    public TaiKhoanDTO suaTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.suaTaiKhoan(taiKhoanDTO);
    }

    @DeleteMapping("/taikhoan/{maTaiKhoan}")
    public void xoaTaiKhoan(@PathVariable String maTaiKhoan) {
        taiKhoanService.xoaTaiKhoan(maTaiKhoan);
    }
}
