package com.fchanblog.fivechan.domain.model;

import java.util.Set;

public class UserWithRoles extends User {
    private Set<Role> roles;

    public UserWithRoles(Long id, String username, Set<Role> roles) {
        super(id, username);
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
