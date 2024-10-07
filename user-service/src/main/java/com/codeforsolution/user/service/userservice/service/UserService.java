package com.codeforsolution.user.service.userservice.service;

import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface UserService {

    public User createUser(User user);

    public String generateToken(String username);

    public void validateToken(String token);
}
