package com.luna.backend.controllers;

import com.luna.backend.entities.User;
import com.luna.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody User user){
        this.userService.create(user);
    }

    @PostMapping("/search")
    public ResponseEntity<User> read(@RequestBody String email){
        return ResponseEntity.ok().body(this.userService.read(email).orElse(null));
    }

    @PutMapping
    public void update(@RequestBody User user){
        this.userService.update(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user){
        this.userService.delete(user);
    }

}
