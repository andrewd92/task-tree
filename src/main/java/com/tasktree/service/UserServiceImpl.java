package com.tasktree.service;

import com.tasktree.model.User;
import com.tasktree.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User create(String name) {
        User user = new User(name);

        return repository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        return repository.findAll();
    }
}
