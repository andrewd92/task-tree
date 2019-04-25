package com.tasktree.service;

import com.tasktree.model.User;

public interface UserService {
    User create(String name);
    Iterable<User> getAll();
}
