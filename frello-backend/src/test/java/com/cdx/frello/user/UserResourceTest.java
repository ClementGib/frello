package com.cdx.frello.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserResourceTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserResource userResource;

    @Test
    public void shouldReturnUser_whenServiceReturnsUser() {
        // Arrange
        Long userId = 1L;
        User myUser = new User();
        myUser.setUserName("aleks");
        when(userService.getUser(userId)).thenReturn(myUser);

        // Act
        User actualUser = userResource.getUser(userId);

        // Assert
        assertThat(actualUser).isEqualTo(myUser);
    }

    @Test
    public void shouldReturnNull_whenServiceReturnsNull() {
        // Arrange
        Long id = null;
        when(userService.getUser(id)).thenReturn(null);

        // Act
        User actualUser = userResource.getUser(id);

        // Assert
        assertThat(actualUser).isEqualTo(null);
    }
}