package com.example.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "petrol_stations")
public class PetrolStationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @Column(name = "types_of_petrol")
    private String typesOfPetrol;
    private Double price;


    @ManyToMany(mappedBy = "stationsEntities", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<CustomerEntity> customerEntities;

}
