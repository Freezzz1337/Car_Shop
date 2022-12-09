package com.github.car.shop.controller.car;

import com.github.car.shop.entity.Car;
import com.github.car.shop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class RemoveCarController {
    @Autowired
    final private CarRepository carRepository;

    @PostMapping("management/car/{id}/remove")
    public String carDetailsRemove(@PathVariable(value = "id") long id, Model model) throws IOException {
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);
        return "redirect:/management/car";
    }


}
