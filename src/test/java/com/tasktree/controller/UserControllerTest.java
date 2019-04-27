package com.tasktree.controller;

import com.tasktree.model.User;
import com.tasktree.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userController = new UserController(userService);
    }

    @Test
    public void testCreate() throws Exception {
        MockMvc mvc = MockMvcBuilders.standaloneSetup(userController).build();

        final String userName = "Andrey";
        User user = new User(userName);

        when(userService.create(userName)).thenReturn(user);

        mvc.perform(get("/user/create/" + userName).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(userName)));
    }
}