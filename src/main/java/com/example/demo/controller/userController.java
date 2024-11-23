package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@Validated
public class userController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User>getUsersList()
    {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody @Valid User user)
    {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable Long id)
    {
        Optional<User>userInfo = userRepository.findById(id);
        return userInfo.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build() );
    }

}
