package com.github.car.shop.controller.worker;

import com.github.car.shop.entity.Position;
import com.github.car.shop.entity.Worker;
import com.github.car.shop.repository.WorkerRepository;
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
public class EditWorkerController {

    @Autowired
    private final WorkerRepository workerRepository;

    @GetMapping("management/worker/{id}/edit")
    public String workerEdit(@PathVariable(value = "id") long id, Model model) {


        Optional<Worker> worker = workerRepository.findById(id);
        ArrayList<Worker> arr = new ArrayList<>();
        worker.ifPresent(arr::add);
        model.addAttribute("worker", arr);
        return "worker/workerEdit";
    }

    @PostMapping("management/worker/{id}/edit")
    public String workerUpdate(@PathVariable(value = "id") long id,
                               @RequestParam String name,
                               @RequestParam String login,
                               @RequestParam Position position,
                               Model model) throws IOException {
        Worker worker = workerRepository.findById(id).get();
        worker.setName(name);
        worker.setLogin(login);
        worker.setPosition(position);
        workerRepository.save(worker);
        return "redirect:/management/worker";
    }
}
