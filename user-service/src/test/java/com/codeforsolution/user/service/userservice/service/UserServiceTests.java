package com.codeforsolution.user.service.userservice.service;

import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
//        User user1 = new User(1L, "John Doe", "john@example.com");
//        User user2 = new User(2L, "Jane Doe", "jane@example.com");
//
//        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
//
//        List<User> users = userService.getAllUsers();
//
//        assertEquals(2, users.size());
//        verify(userRepository, times(1)).findAll();
    }
}
