package com.security.SecurityDemo.services;

import com.security.SecurityDemo.models.Users;
import com.security.SecurityDemo.repositories.UserRepository;
import com.security.SecurityDemo.securityconfig.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cet utilisateur n'existe pas dans note base de données");
        }

        return new MyUserDetails(user);
    }
}
