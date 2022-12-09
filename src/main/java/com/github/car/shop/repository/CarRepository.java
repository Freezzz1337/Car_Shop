package com.github.car.shop.repository;

import com.github.car.shop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM car", nativeQuery = true)
    public Iterable<Car> getAllCar();



}
