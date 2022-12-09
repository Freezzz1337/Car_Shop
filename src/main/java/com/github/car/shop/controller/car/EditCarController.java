package com.github.car.shop.controller.car;

import com.github.car.shop.entity.Car;
import com.github.car.shop.entity.Supplier;
import com.github.car.shop.repository.CarRepository;
import com.github.car.shop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EditCarController {
    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final SupplierRepository supplierRepository;

    @GetMapping("/management/car/{id}/edit")
    public String carDetailsEdit(@PathVariable(value = "id") long id, Model model) {

        if (!carRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Car> car = carRepository.findById(id);
        ArrayList<Car> arr = new ArrayList<>();
        car.ifPresent(arr::add);
        model.addAttribute("car", arr);
        return "car/carDetailsEdit";

    }


    @PostMapping("/management/car/{id}/edit")
    public String carDetailsUpdate(@PathVariable(value = "id") long id,
                                   @RequestParam String name,
                                   @RequestParam Long supplier,
                                   @RequestParam String color,
                                   @RequestParam String description,
                                   @RequestParam String fuel,
                                   @RequestParam String equipment,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfManufacture,
                                   @RequestParam Double mileage,
                                   @RequestParam Double engine,
                                   @RequestParam Double price,
                                   @RequestParam("picture") Optional<MultipartFile> picture,
                                   Model model) throws IOException {
        Supplier sup = supplierRepository.findById(supplier).orElseThrow();
        Car car = carRepository.findById(id).get();
        car.setName(name);
        car.setSupplier(sup);
        car.setColor(color);
        car.setDescription(description);
        car.setFuel(fuel);
        car.setMileage(mileage);
        car.setEngine(engine);
        car.setPrice(price);
        car.setEquipment(equipment);
        car.setDateOfManufacture(dateOfManufacture);
        car.setPicture(picture.get().getBytes());
        carRepository.save(car);
        return "redirect:/management/car";
    }
}
