package com.github.car.shop.controller.car;

import com.github.car.shop.entity.Car;
import com.github.car.shop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CarController {

    @Autowired
    private final CarRepository carRepository;

    @GetMapping("management/car")
    public String car(Model model) {

        Iterable<Car> car = carRepository.getAllCar();
        model.addAttribute("car", car);
        return "car/car";
    }
}
