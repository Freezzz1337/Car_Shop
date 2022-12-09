package com.github.car.shop.controller;

import com.github.car.shop.entity.Car;
import com.github.car.shop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Car> car = carRepository.findAll();
        model.addAttribute("car", car);
        return ("/home");
    }
}
