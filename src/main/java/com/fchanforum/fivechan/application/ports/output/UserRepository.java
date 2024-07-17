package com.fchanblog.fivechan.application.ports.output;

import com.fchanblog.fivechan.domain.model.User;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
}
