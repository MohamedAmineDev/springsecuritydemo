package com.security.SecurityDemo.repositories;

import com.security.SecurityDemo.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByEmail(String email);
}
