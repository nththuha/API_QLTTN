package com.example.QLTTN.service.Impl;

import com.example.QLTTN.dto.MonHocDTO;
import com.example.QLTTN.entity.MonHocEntity;
import com.example.QLTTN.exception.NotFoundException;
import com.example.QLTTN.repository.MonHocRepository;
import com.example.QLTTN.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonHocServiceImpl implements MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;

    @Override
    public List<MonHocDTO> getDSMonHoc() {
        List<MonHocEntity> DSMonHoc = monHocRepository.findAll();
        return DSMonHoc.stream().map(MonHocDTO::new).collect(Collectors.toList());
    }

    @Override
    public void xoaMonHoc(String maMonHoc) {
        monHocRepository.deleteById(maMonHoc);
    }

    @Override
    public MonHocDTO themMonHoc(MonHocDTO monHocDTO) {
        MonHocEntity saveMonHocDTO = monHocRepository.save(monHocDTO.toEntity());
        return new MonHocDTO(saveMonHocDTO);
    }

    @Override
    public MonHocDTO suaMonhoc(MonHocDTO monHocDTO) {
        MonHocEntity monHocEntity = monHocRepository.findById(monHocDTO.getMaMonHoc()).orElseThrow(() -> new NotFoundException("Môn học " + monHocDTO.getMaMonHoc() +" không tồn tại!"));
        monHocEntity.setTenMonHoc(monHocDTO.getTenMonHoc());
        MonHocEntity saveMonHocDTO = monHocRepository.save(monHocEntity);
        return new MonHocDTO(saveMonHocDTO);
    }

    @Override
    public MonHocDTO layMonHoc(String maMonHoc) {
        MonHocEntity monHocEntity = monHocRepository.findById(maMonHoc).orElseThrow(() -> new NotFoundException("Môn học " + maMonHoc + " không tồn tại"));
        return new MonHocDTO(monHocEntity);
    }
}
