package com.example.redis.user;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/save")
    public User save(){
        User user = new User();
        user.setName("leebokeum");
        user.setSalary(500000000L);
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public Iterator<User> getUsers(){
        return userRepository.findAll().iterator();
    }

}
