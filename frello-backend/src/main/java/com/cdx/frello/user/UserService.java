package com.cdx.frello.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    User getUser(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }
}
