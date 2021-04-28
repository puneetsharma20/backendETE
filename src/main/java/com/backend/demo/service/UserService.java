package com.backend.demo.service;

import com.backend.demo.model.UserDetail;
import com.backend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void registerUser(UserDetail newUser){
        userRepository.register(newUser);
    }
}
