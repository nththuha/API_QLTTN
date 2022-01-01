package com.example.QLTTN.controller;

import com.example.QLTTN.dto.CauHoiDTO;
import com.example.QLTTN.service.CauHoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CauHoiController {
    @Autowired
    private CauHoiService cauHoiService;

    @GetMapping("/cauhoi")
    public List<CauHoiDTO> layDSCauHoi() {
        return cauHoiService.getDSCauHoi();
    }

    @GetMapping("/cauhoi/danhsach/{maMonHoc}")
    public List<CauHoiDTO> layDSCauHoiTheoMon(@PathVariable String maMonHoc, @RequestParam("loai") String loai) {
        if(loai.equals("All")) {
            return cauHoiService.getDSCauHoiTheoMon(maMonHoc);
        }
        else {
            return cauHoiService.getDSNgauNhienCauHoi(maMonHoc);
        }
    }

    @GetMapping("/cauhoi/{idCH}")
    public CauHoiDTO layCauHoi(@PathVariable Integer idCH){
        return cauHoiService.layCauHoi(idCH);
    }

    @PostMapping("/cauhoi")
    public CauHoiDTO themCauHoi(@Valid @RequestBody CauHoiDTO cauHoiDTO) {
        return cauHoiService.themCauHoi(cauHoiDTO);
    }

    @PutMapping("/cauhoi")
    public CauHoiDTO suaCauHoi(@Valid @RequestBody CauHoiDTO cauHoiDTO){
        return cauHoiService.suaCauHoi(cauHoiDTO);
    }

    @DeleteMapping("/cauhoi/{idCH}")
    public void xoaCauHoi(@PathVariable Integer idCH) {
        cauHoiService.xoaCauHoi(idCH);
    }
}
