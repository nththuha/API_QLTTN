package com.example.QLTTN.repository;

import com.example.QLTTN.entity.ChiTietThiEntity;
import com.example.QLTTN.entity.MonHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietThiRepository extends JpaRepository<ChiTietThiEntity, Integer> {
    List<ChiTietThiEntity> findByMonHoc_MaMonHoc(String maMonHoc);
}
