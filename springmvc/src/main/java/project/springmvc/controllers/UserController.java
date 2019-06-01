package project.springmvc.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.springmvc.model.User;
import project.springmvc.repository.UserRepository;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> all() {
        return this.userRepository.findAll();
    }


    @PostMapping
    public User add(@RequestBody User p, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        p.setClientID(UUID.randomUUID());
        this.userRepository.save(p);
        return p;
    }
    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        boolean flag = false;
        User usr = null;
        List<User> list = userRepository.findAll();
        for(User u: list)
        {
            if( user.getLogin().equals(u.getLogin()) && user.getPassword().equals(u.getPassword()))
            {
            usr = u;
            }
        }
        return usr;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable String id) {
        this.userRepository.deleteById(UUID.fromString(id));
    }

    @RequestMapping("/login/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return this.userRepository.findById(UUID.fromString(id));
    }
}
