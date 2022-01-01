package com.example.QLTTN.repository;

import com.example.QLTTN.entity.MonHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHocEntity, String> {
}
