package com.example.car.repository;

import com.example.car.entity.CarEntity;
import com.example.car.entity.CustomerEntity;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
//    List<CarEntity> findByBrandAndModel(String brand, String model);
//    Optional<List<CarEntity>> findByFirstLetter(String letter);

//    Optional<List<CarEntity>> findByFirstLetter(String letter);

    //JPQL
    @Query(value = "SELECT * FROM car WHERE price > :minPrice", nativeQuery = true)
    List<CarEntity> findCarByMinPrice(@Param("minPrice") Integer minPrice);
}
