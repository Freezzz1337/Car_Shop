package com.github.car.shop.controller.car;

import com.github.car.shop.entity.Car;
import com.github.car.shop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CarDetailsController {

    private final CarRepository carRepository;

    @GetMapping("/carDetails/{id}")
    public String carDetails(@PathVariable(value = "id") long id, Model model) {
        if(!carRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Car> car = carRepository.findById(id);
        ArrayList<Car> arr = new ArrayList<>();
        car.ifPresent(arr::add);
        model.addAttribute("car", arr);
        return "car/carDetails";
    }

}
