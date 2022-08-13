package com.security.SecurityDemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "myusers")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String roles;


    public Users(@JsonProperty("email") String email, @JsonProperty("firstname") String firstName, @JsonProperty("lastname") String lastName, @JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
