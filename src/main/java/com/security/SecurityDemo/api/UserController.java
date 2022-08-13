package com.security.SecurityDemo.api;

import com.security.SecurityDemo.models.Users;
import com.security.SecurityDemo.roles.Roles;
import com.security.SecurityDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "app/api/manage_user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("add_user")
    public boolean addUsers(@RequestBody Users user) {
        // user.setRoles(String.valueOf(Roles.TESTEUR));
        user.setRoles(Roles.ROLE_ADMIN.name());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.addAUser(user);
    }

    @GetMapping("users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
