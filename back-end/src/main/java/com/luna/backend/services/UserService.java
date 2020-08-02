package com.luna.backend.services;

import com.luna.backend.entities.User;
import com.luna.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user){
        this.userRepository.save(user);
    }

    public Optional<User> read(String email){
        return this.userRepository.findByEmail(email);
    }

    public void update(User user){
        this.userRepository.save(user);
    }

    public void delete(User user){
        this.userRepository.delete(user);
    }
}
