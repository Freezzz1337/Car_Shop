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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AddNewCarController {

    @Autowired
    final private CarRepository carRepository;

    @Autowired
    final private SupplierRepository supplierRepository;

    @GetMapping("management/car/add")
    public String add(Model model) {
        return "car/addNewCar";
    }

    @PostMapping("management/car/add")
    public String add(@RequestParam String name,
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
        Car car = new Car(name, sup, color, fuel, description, equipment, dateOfManufacture, price, mileage, engine, picture.get().getBytes());
        carRepository.save(car);
        return "redirect:/management/car";
    }

}
