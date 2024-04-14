package com.cdx.frello.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    User createUser(User user) {
        return userRepository.save(user);
    }
}
