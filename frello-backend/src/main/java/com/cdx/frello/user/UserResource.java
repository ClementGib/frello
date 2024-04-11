package com.cdx.frello.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @GetMapping("/")
    private User getUser() {
        return new User();
    }
}