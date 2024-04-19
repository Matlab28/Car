package com.example.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand, model, color;
    private Boolean used;
    private Integer price, odometer;

    @Column(name = "year_of_cars")
    private Integer yearOfCars;

    @Column(name = "number_of_doors")
    private Integer numberOfDoors;

    @Column(name = "number_of_users")
    private Integer numberOfUsers;
    private Double motor;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private CustomerEntity customers;

//    @OneToMany(mappedBy = "carEntity", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<CustomerEntity> customerEntity;

    @OneToOne(mappedBy = "car")
    private DocumentsEntity documents;
}
