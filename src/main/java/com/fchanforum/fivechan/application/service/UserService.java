package com.fchanblog.fivechan.application.service;

import com.fchanblog.fivechan.domain.model.User;
import com.fchanblog.fivechan.domain.model.UserWithRoles;

public class UserService {
    public void createUser(User user) {
        // Lógica para crear usuario
    }

    public void createUserWithRoles(UserWithRoles userWithRoles) {
        createUser(userWithRoles); // Sustitución válida según LSP
    }
}
