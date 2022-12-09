package com.github.car.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/aboutUs")
    public String aboutUS(Model model){
        return "aboutUs";
    }

}
