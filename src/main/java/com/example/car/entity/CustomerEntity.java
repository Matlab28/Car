package com.example.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, email, number;

    @ManyToMany
    @JoinTable(name = "customer_petrol",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<PetrolStationsEntity> stationsEntities;

    @OneToMany(mappedBy = "customers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CarEntity> car;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    @JsonIgnore
//    private CarEntity carEntity;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private DocumentsEntity documents;
}
