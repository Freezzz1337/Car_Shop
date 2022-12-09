package com.github.car.shop.controller.worker;

import com.github.car.shop.entity.Position;
import com.github.car.shop.entity.Worker;
import com.github.car.shop.repository.PositionRepository;
import com.github.car.shop.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AddNewWorkerController {
    @Autowired
    private final WorkerRepository workerRepository;
    @Autowired
    private final PositionRepository positionRepository;

    @GetMapping("management/worker/add")
    public String addWorker(Model model) {
        return "worker/addNewWorker";
    }


    @PostMapping("management/worker/add")
    public String addWorker(@RequestParam String name,
                            @RequestParam String login,
                            @RequestParam Long position,
                            Model model) {
        Position posit = positionRepository.findById(position).orElseThrow();
        Worker worker = new Worker(name, login, posit);
        workerRepository.save(worker);
        return "redirect:/management/worker";
    }
}
