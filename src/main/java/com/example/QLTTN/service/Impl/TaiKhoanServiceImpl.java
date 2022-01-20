package com.example.QLTTN.service.Impl;

import com.example.QLTTN.dto.TaiKhoanDTO;
import com.example.QLTTN.entity.TaiKhoanEntity;
import com.example.QLTTN.exception.NotFoundException;
import com.example.QLTTN.repository.TaiKhoanRepository;
import com.example.QLTTN.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;


    @Override
    public List<TaiKhoanDTO> getTaiKhoanTheoLoai(String loai, String ten) {
        List<TaiKhoanEntity> DSTaiKhoan = taiKhoanRepository.findByLoai(loai);
        if(ten.equals("#")){
            return DSTaiKhoan.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
        }
        else{
            List<TaiKhoanEntity> DS = new ArrayList<>();
            for (TaiKhoanEntity e: DSTaiKhoan) {
                if(e.getTen().toLowerCase().contains(ten.toLowerCase())){
                    DS.add(e);
                }
            }
            return DS.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
        }
    }

    @Override
    public List<TaiKhoanDTO> getDSTaiKhoan() {
        List<TaiKhoanEntity> dSTaiKhoan = taiKhoanRepository.findAll();
        return dSTaiKhoan.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    @Override
    public void xoaTaiKhoan(String maTaiKhoan) {
        taiKhoanRepository.deleteById(maTaiKhoan);
    }

    @Override
    public TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity saveTaiKhoanOTD = taiKhoanRepository.save(taiKhoanDTO.toEntity());
        return new TaiKhoanDTO(saveTaiKhoanOTD);
    }

    @Override
    public TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.getById(taiKhoanDTO.getMaTaiKhoan());
        taiKhoanEntity.setHo(taiKhoanDTO.getHo());
        taiKhoanEntity.setTen(taiKhoanDTO.getTen());
        taiKhoanEntity.setEmail(taiKhoanDTO.getEmail());
        taiKhoanEntity.setLoai(taiKhoanDTO.getLoai());
        taiKhoanEntity.setMatKhau(taiKhoanDTO.getMatKhau());
        TaiKhoanEntity saveTaiKhoanOTD = taiKhoanRepository.save(taiKhoanEntity);
        return new TaiKhoanDTO(saveTaiKhoanOTD);
    }

    @Override
    public TaiKhoanDTO kiemTraDangNhap(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findById(taiKhoanDTO.getMaTaiKhoan()).orElseThrow(()-> new NotFoundException("Tài khoản " + taiKhoanDTO.getMaTaiKhoan() + " không tồn tại!"));
        if(taiKhoanEntity.getMatKhau().equals(taiKhoanDTO.getMatKhau()))
            return new TaiKhoanDTO(taiKhoanEntity);
        else return null;
    }

    @Override
    public TaiKhoanDTO layTaiKhoan(String maTaiKhoan) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findById(maTaiKhoan).orElseThrow(() -> new NotFoundException("Tài khoản " + maTaiKhoan + " không tồn tại"));
        return new TaiKhoanDTO(taiKhoanEntity);
    }
}
