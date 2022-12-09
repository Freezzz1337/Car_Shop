package com.github.car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {@Index(name = "nameAndPrice", columnList = "name,price")})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;
    private String color;
    private String fuel;
    @Column(length = 1000)
    private String description;
    private String equipment;
    private LocalDate dateOfManufacture;
    private double price;
    private double mileage;
    private double engine;

    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    public Car(String name, Supplier supplier, String color, String fuel, String description, String equipment, LocalDate dateOfManufacture, double price, double mileage, double engine, byte[] picture) {
        this.name = name;
        this.supplier = supplier;
        this.color = color;
        this.fuel = fuel;
        this.description = description;
        this.equipment = equipment;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
        this.mileage = mileage;
        this.engine = engine;
        this.picture = picture;
    }
}
