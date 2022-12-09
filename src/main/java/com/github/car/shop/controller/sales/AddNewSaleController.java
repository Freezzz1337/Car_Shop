package com.github.car.shop.controller.sales;

import com.github.car.shop.entity.Car;
import com.github.car.shop.entity.Sales;
import com.github.car.shop.entity.Worker;
import com.github.car.shop.repository.CarRepository;
import com.github.car.shop.repository.SalesRepository;
import com.github.car.shop.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Controller
public class AddNewSaleController {

    @Autowired
    private final SalesRepository salesRepository;
    @Autowired
    private final WorkerRepository workerRepository;
    @Autowired
    private final CarRepository carRepository;

    @GetMapping("management/addSales")
    public String addSale(Model model) {
        return "sales/addSale";
    }

    @Transactional
    @PostMapping("management/addSales")
    public String addSale(@RequestParam Long auto,
                          @RequestParam Long worker,
                          @RequestParam Double price,
                          Model model) {
        Car car = carRepository.findById(auto).orElseThrow();
        Worker worker1 = workerRepository.findById(worker).orElseThrow();
        Sales sales = new Sales(car, worker1, price);
        salesRepository.save(sales);
        return "redirect:/management";
    }

}
