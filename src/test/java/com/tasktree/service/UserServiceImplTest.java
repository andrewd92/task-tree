package com.tasktree.service;

import com.tasktree.TaskTreeApplication;
import com.tasktree.model.User;
import com.tasktree.repository.UserRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
}
