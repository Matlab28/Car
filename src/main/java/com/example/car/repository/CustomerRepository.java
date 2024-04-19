package com.example.car.repository;


import com.example.car.entity.CarEntity;
import com.example.car.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    Optional<CustomerEntity> findByNameOrEmail(String name, String email);
}
