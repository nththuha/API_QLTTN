package com.example.QLTTN.controller;

import com.example.QLTTN.dto.MonHocDTO;
import com.example.QLTTN.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/monhoc")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping("")
    public List<MonHocDTO> layDSMonHoc() {
        return monHocService.getDSMonHoc();
    }

    @GetMapping("/{maMonHoc}")
    public MonHocDTO layMonHoc(@PathVariable String maMonHoc) {
        return monHocService.layMonHoc(maMonHoc);
    }

    @PostMapping("")
    public MonHocDTO themMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        return monHocService.themMonHoc(monHocDTO);
    }

    @PutMapping("")
    public MonHocDTO suaMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        return monHocService.suaMonhoc(monHocDTO);
    }

    @DeleteMapping("/{maMonHoc}")
    public void xoaMonHoc(@PathVariable String maMonHoc) {
        monHocService.xoaMonHoc(maMonHoc);
    }
}