package com.cdx.frello.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    private User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}