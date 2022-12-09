package com.github.car.shop.controller.supplier;

import com.github.car.shop.entity.Supplier;
import com.github.car.shop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SupplierController {

    @Autowired
    private final SupplierRepository supplierRepository;

    @GetMapping("management/supplier")
    public String supplier(Model model) {
        Iterable<Supplier> suppliers = supplierRepository.findAll();
        model.addAttribute("suppliers", suppliers);
        return "supplier/supplier";
    }
}
