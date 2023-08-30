package com.example.bookmyevemt.services;

import com.example.bookmyevemt.models.User;
import com.example.bookmyevemt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public Optional<User> getUserById(Long userId)
    {
        return userRepository.findById(userId);
    }
}
