package com.example.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "documents")
public class DocumentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_no")
    private String licNo;

    @Column(name = "car_no")
    private String carNo;

    private String owner;

    @OneToOne
    private CustomerEntity customer;

    @OneToOne
    private CarEntity car;

}
