package com.cdx.frello.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldReturnUser_whenUserFoundInRepository() {
        // Arrange
        User myUser = new User();
        Long userId = 1L;
        // Optional<User>
        when(userRepository.findById(userId)).thenReturn(Optional.of(myUser));

        // Act
        User user = userService.getUser(userId);


        // Assert
        assertThat(user).isEqualTo(myUser);
    }

    @Test
    public void shouldReturnNull_whenNoUserFoundInRepository() {
        // Arrange
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        User user = userService.getUser(userId);


        // Assert
        assertThat(user).isEqualTo(null);
    }

    @Test
    public void shouldReturnUser_whenUserIsCreated() {
        // Arrange
        User newUser = new User();
        newUser.setUserName("toto");
        when(userRepository.save(newUser)).thenReturn(newUser);

        // Act
        User userCreated = userService.createUser(newUser);

        // Assert
        assertThat(userCreated).isEqualTo(newUser);
    }

    @Test
    public void shouldReturnNull_whenUserIsNotCreated() {
        // Arrange
        User newUser = new User();
        when(userRepository.save(newUser)).thenReturn(null);

        // Act
        User userCreated = userService.createUser(newUser);

        // Assert
        assertThat(userCreated).isEqualTo(null);
    }
}