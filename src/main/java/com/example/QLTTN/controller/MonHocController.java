package com.example.QLTTN.controller;

import com.example.QLTTN.dto.MonHocDTO;
import com.example.QLTTN.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping("/monhoc")
    public List<MonHocDTO> layDSMonHoc() {
        return monHocService.getDSMonHoc();
    }

    @GetMapping("/monhoc/{maMonHoc}")
    public MonHocDTO layMonHoc(@PathVariable String maMonHoc) {
        return monHocService.layMonHoc(maMonHoc);
    }

    @PostMapping("/monhoc")
    public MonHocDTO themMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        return monHocService.themMonHoc(monHocDTO);
    }

    @PutMapping("/monhoc")
    public MonHocDTO suaMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        return monHocService.suaMonhoc(monHocDTO);
    }

    @DeleteMapping("/monhoc/{maMonHoc}")
    public void xoaMonHoc(@PathVariable String maMonHoc) {
        monHocService.xoaMonHoc(maMonHoc);
    }
}