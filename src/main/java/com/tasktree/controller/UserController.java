package com.tasktree.controller;

import com.tasktree.model.User;
import com.tasktree.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @RequestMapping("/user/create/{name}")
    User create(@PathVariable String name) {

        return service.create(name);
    }
}
