package com.example.car.repository;

import com.example.car.entity.PetrolStationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetrolStationsRepository extends JpaRepository<PetrolStationsEntity, Long> {
    @Query("SELECT p FROM PetrolStationsEntity p  WHERE p.price >= :minPrice")
    Optional<List<PetrolStationsEntity>> findByMinPrice(@Param("minPrice") Double minPrice);
}
