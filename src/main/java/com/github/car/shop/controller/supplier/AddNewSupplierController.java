package com.github.car.shop.controller.supplier;

import com.github.car.shop.entity.Supplier;
import com.github.car.shop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class AddNewSupplierController {

    @Autowired
    private final SupplierRepository supplierRepository;

    @GetMapping("management/supplier/add")
    public String add(Model model) {
        return "supplier/addNewSupplier";
    }


    @PostMapping("management/supplier/add")
    public String add(@RequestParam String name,
                      Model model) throws IOException {
        Supplier supplier = new Supplier(name);
        supplierRepository.save(supplier);
        return "supplier/addNewSupplier";
    }
}
