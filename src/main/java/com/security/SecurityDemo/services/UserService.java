package com.security.SecurityDemo.services;

import com.security.SecurityDemo.models.Users;
import com.security.SecurityDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addAUser(Users user) {
        return userRepository.save(user) != null;
    }

    public List<Users> getAllUsers() {
        Iterable<Users> usersIterable = userRepository.findAll();
        List<Users> users = new ArrayList<>();
        usersIterable.forEach((u) -> {
            users.add(u);
        });
        return users;
    }
}
