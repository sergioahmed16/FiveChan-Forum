package com.fchanblog.fivechan.infrastructure.adapters.output;

import com.fchanblog.fivechan.application.ports.output.UserRepository;
import com.fchanblog.fivechan.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }
}
