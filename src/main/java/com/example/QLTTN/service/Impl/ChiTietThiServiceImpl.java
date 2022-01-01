package com.example.QLTTN.service.Impl;

import com.example.QLTTN.dto.ChiTietThiDTO;
import com.example.QLTTN.entity.ChiTietThiEntity;
import com.example.QLTTN.entity.MonHocEntity;
import com.example.QLTTN.exception.NotFoundException;
import com.example.QLTTN.repository.ChiTietThiRepository;
import com.example.QLTTN.repository.MonHocRepository;
import com.example.QLTTN.service.ChiTietThiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietThiServiceImpl implements ChiTietThiService {
    @Autowired
    ChiTietThiRepository chiTietThiRepository;

    @Override
    public List<ChiTietThiDTO> getDSChiTietThi() {
        List<ChiTietThiEntity> DSChiTietThi = chiTietThiRepository.findAll();
        return DSChiTietThi.stream().map(ChiTietThiDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ChiTietThiDTO> getChiTietThiTheoMon(String maMonHoc) {
        List<ChiTietThiEntity> DSChiTietThi = chiTietThiRepository.findByMonHoc_MaMonHoc(maMonHoc);
        return DSChiTietThi.stream().map(ChiTietThiDTO::new).collect(Collectors.toList());
    }

    @Override
    public ChiTietThiDTO themChiTietThi(ChiTietThiDTO chiTietThiDTO) {
        ChiTietThiEntity saveChiTietThiDTO = chiTietThiRepository.save(chiTietThiDTO.toEntity());
        return new ChiTietThiDTO(saveChiTietThiDTO);
    }
}
