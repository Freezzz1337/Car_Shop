package com.github.car.shop.repository;

import com.github.car.shop.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {

    @Procedure(name = "sumPrice")
    double sumPrice();
}
