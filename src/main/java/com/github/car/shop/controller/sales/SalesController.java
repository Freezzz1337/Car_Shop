package com.github.car.shop.controller.sales;

import com.github.car.shop.entity.Sales;
import com.github.car.shop.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SalesController {

    @Autowired
    private final SalesRepository salesRepository;

    @GetMapping("management/sales")
    public String sales(Model model) {
        Iterable<Sales> sales = salesRepository.findAll();
        model.addAttribute("sales", sales);

        double sum = salesRepository.sumPrice();
        model.addAttribute("sum", sum);
        return "sales/sales";
    }
}
