package com.security.SecurityDemo.roles;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Roles {
    ROLE_ADMIN("ADMIN"),
    ROLE_EMPLOYEE("EMPLOYEE");
    private String permission;

    Roles(String p) {
        this.permission = p;
    }
}
