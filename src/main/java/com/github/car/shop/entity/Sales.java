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
@Table(indexes = {@Index(name = "priceIndexSales", columnList = "price")})
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    double price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Sales(Car car, Worker worker1, double price) {
        this.car = car;
        this.worker = worker1;
        this.price = price;
    }
}
