package com.example.QLTTN.controller;

import com.example.QLTTN.dto.ChiTietThiDTO;
import com.example.QLTTN.service.ChiTietThiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chitietthi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChiTietThiController {
    @Autowired
    private ChiTietThiService chiTietThiService;

    @GetMapping("")
    public List<ChiTietThiDTO> layDSChiTietThi() {
        return chiTietThiService.getDSChiTietThi();
    }

    @GetMapping("/{maMonHoc}")
    public List<ChiTietThiDTO> layDSChiTietThiTheoMon(@PathVariable String maMonHoc) {
        return chiTietThiService.getChiTietThiTheoMon(maMonHoc);
    }

    @PostMapping("")
    public ChiTietThiDTO themChiTietThi(@Valid @RequestBody ChiTietThiDTO chiTietThiDTO) {
        return chiTietThiService.themChiTietThi(chiTietThiDTO);
    }
}
