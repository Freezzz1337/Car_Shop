package com.github.car.shop.controller.worker;

import com.github.car.shop.entity.Worker;
import com.github.car.shop.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class WorkerController {

    @Autowired
    private final WorkerRepository workerRepository;

    @GetMapping("management/worker")
    public String worker(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        return "worker/worker";
    }
}
