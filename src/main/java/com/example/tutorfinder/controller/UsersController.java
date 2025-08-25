package com.example.tutorfinder.controller;

import com.example.tutorfinder.entity.User;
import com.example.tutorfinder.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserRepository userRepository;
    public UsersController(UserRepository userRepository){ this.userRepository = userRepository; }
    @GetMapping public List<User> all(){ return userRepository.findAll(); }
}
