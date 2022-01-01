package com.example.QLTTN.repository;

import com.example.QLTTN.entity.CauHoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CauHoiRepository extends JpaRepository<CauHoiEntity, Integer> {
    List<CauHoiEntity> findByMonHoc_MaMonHoc(String maMonHoc);
}
