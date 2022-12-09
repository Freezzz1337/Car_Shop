package com.github.car.shop.controller.supplier;

import com.github.car.shop.entity.Supplier;
import com.github.car.shop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class EditSupplierController {

    @Autowired
    private final SupplierRepository supplierRepository;

    @GetMapping("management/supplier/{id}/edit")
    public String supplierEdit(@PathVariable(value = "id") long id, Model model) {


        Optional<Supplier> supplier = supplierRepository.findById(id);
        ArrayList<Supplier> arr = new ArrayList<>();
        supplier.ifPresent(arr::add);
        model.addAttribute("supplier", arr);
        return "supplier/supplierEdit";
    }

    @PostMapping("management/supplier/{id}/edit")
    public String supplierUpdate(@PathVariable(value = "id") long id,
                                   @RequestParam String name,
                                   Model model) throws IOException {
        Supplier supplier = supplierRepository.findById(id).get();
        supplier.setName(name);
        supplierRepository.save(supplier);
        return "redirect:/management/supplier";
    }
}
