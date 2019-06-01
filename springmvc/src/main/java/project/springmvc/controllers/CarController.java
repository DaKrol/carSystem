package project.springmvc.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.springmvc.model.Car;
import project.springmvc.model.Repair;
import project.springmvc.model.User;
import project.springmvc.repository.CarRepository;
import project.springmvc.repository.RepairRepository;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {

    private CarRepository carRepository;
    private RepairRepository repairRepository;

    public CarController(CarRepository carRepository, RepairRepository repairRepository) {
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
    }

    @GetMapping("/all")
    public List<Car> all() {
        return this.carRepository.findAll();
    }

    @RequestMapping("/{id}")
    public List<Car> getCarById(@PathVariable String id) {
        List<Car> list;
        list = this.carRepository.findAll();
        List<Car> output = this.carRepository.findAll();
        output.clear();
        for (Car c : list) {
            if (UUID.fromString(id).equals(c.getUserId())) {
                output.add(c);
            }
        }
        return output;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable String id) {
        List<Repair> list;
        list = this.repairRepository.findAll();
        for (Repair r : list) {
            if (UUID.fromString(id).equals(r.getCarId())) {
                this.repairRepository.deleteById(r.getId());
            }
        }
        this.carRepository.deleteById(UUID.fromString(id));
    }

    @PostMapping
    public Car add(@RequestBody Car c, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        c.setId(UUID.randomUUID());

        this.carRepository.save(c);
        return c;
    }

}
