package org.example.testingp.service;

import org.example.testingp.model.entity.User;
import org.example.testingp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
