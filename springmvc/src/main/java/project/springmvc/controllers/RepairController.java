package project.springmvc.controllers;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.springmvc.model.Car;
import project.springmvc.model.Repair;
import project.springmvc.model.User;
import project.springmvc.repository.CarRepository;
import project.springmvc.repository.RepairRepository;
import project.springmvc.repository.UserRepository;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/repair")
@CrossOrigin
public class RepairController {

    public RepairRepository repairRepository;
    public UserRepository userRepository;
    public CarRepository carRepository;

    public RepairController(RepairRepository repairRepository, UserRepository userRepository, CarRepository carRepository) {
        this.repairRepository = repairRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<Repair> all() {
        return this.repairRepository.findAll();
    }

    @PostMapping("/update")
    public Repair update(@RequestBody Repair c, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        List<Repair> list;
        list = this.repairRepository.findAll();
        for (Repair r : list) {
            if (r.getId().equals(c.getId())) {
                c.setCarId(r.getCarId());
                this.repairRepository.delete(r);
                this.repairRepository.save(c);
            }
        }
        return c;
    }

    @RequestMapping("/{id}")
    public List<Repair> getRepairById(@PathVariable String id) {
        List<User> users = this.userRepository.findAll();
        List<Car> car = this.carRepository.findAll();

        List<Repair> list;
        list = this.repairRepository.findAll();
        List<Repair> output = this.repairRepository.findAll();
        output.clear();
        for (User u : users) {
            if (UUID.fromString(id).equals(u.getId())) {
                for (Car c : car) {
                    if (c.getUserId().equals(u.getId())) {
                        for (Repair r : list) {
                            if (r.getCarId().equals(c.getId())) {
                                output.add(r);
                            }
                        }
                    }
                }
            }
        }
        return output;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRepairById(@PathVariable String id) {
        List<Repair> list;
        list = this.repairRepository.findAll();
        List<Repair> output = this.repairRepository.findAll();
        output.clear();
        for (Repair r : list) {
            if (UUID.fromString(id).equals(r.getCarId())) {
                this.repairRepository.deleteById(r.getId());
            }
        }
    }

    @PostMapping
    public Repair add(@RequestBody Repair c, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        c.setId(UUID.randomUUID());
        this.repairRepository.save(c);
        return c;
    }
}
