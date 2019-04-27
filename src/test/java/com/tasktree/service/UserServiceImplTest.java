package com.tasktree.service;

import com.google.common.collect.Iterables;
import com.tasktree.model.User;
import com.tasktree.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void whenSaveUserItShouldReturnUser() {
        final String name = "Andrey";

        when(userRepository.save(any(User.class))).thenReturn(new User(name));

        User created = userService.create(name);

        assertEquals(name, created.getName());
    }

    @Test
    public void getAllShouldReturnUsers() {
        List<User> users = new ArrayList<>();

        for (int i =0; i < 3; i++) {
            String name = UUID.randomUUID().toString();
            User user = new User(name);

            users.add(user);
        }

        when(userRepository.findAll()).thenReturn(users);

        assertEquals(3, Iterables.size(userService.getAll()));
    }
}
