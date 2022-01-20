package com.example.QLTTN.controller;

import com.example.QLTTN.dto.TaiKhoanDTO;
import com.example.QLTTN.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("") // truyền loại và tên, nếu không có tên thì tên để #
    public List<TaiKhoanDTO> layDSTheoLoai(@RequestParam(value = "loai")String loai, @RequestParam(value = "ten")String ten){
        return taiKhoanService.getTaiKhoanTheoLoai(loai, ten);
    }

    @GetMapping("/danhsach")
    public List<TaiKhoanDTO> layDSTaiKhoan(){
        return taiKhoanService.getDSTaiKhoan();
    }

    @GetMapping("/{maTaiKhoan}")
    public TaiKhoanDTO layTaiKhoan(@PathVariable String maTaiKhoan){
        return taiKhoanService.layTaiKhoan(maTaiKhoan);
    }

    @PostMapping("")
    public TaiKhoanDTO themTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }

    @PutMapping("")
    public TaiKhoanDTO suaTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.suaTaiKhoan(taiKhoanDTO);
    }

    @DeleteMapping("/{maTaiKhoan}")
    public void xoaTaiKhoan(@PathVariable String maTaiKhoan) {
        taiKhoanService.xoaTaiKhoan(maTaiKhoan);
    }
}
