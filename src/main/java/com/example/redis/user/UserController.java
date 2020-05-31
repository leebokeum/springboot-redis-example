package com.example.redis.user;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public UserController(UserRepository userRepository, RedisTemplate<String, Object> redisTemplate) {
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public User save(){
        User user = new User();
        user.setName("leebokeum");
        user.setSalary(500000000L);
        return userRepository.save(user);
    }

    @GetMapping("/saveForVop")
    public String saveForVop(){
        User user = new User();
        user.setName("har");
        user.setSalary(900000000L);
        //get/set을 위한 객체
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        vop.set("idx1", user);
        return "저장 완료";
    }

    @GetMapping("/users")
    public Iterator<User> getUsers(){
        return userRepository.findAll().iterator();
    }

    @GetMapping("/getUserForVop")
    public User getUserForVop(){
        User user = (User) redisTemplate.opsForValue().get("idx1");
        return user;
    }

}
