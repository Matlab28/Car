package com.example.car.repository;

import com.example.car.entity.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<DocumentsEntity, Long> {
}
