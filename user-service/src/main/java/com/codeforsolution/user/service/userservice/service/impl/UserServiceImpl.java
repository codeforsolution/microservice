package com.codeforsolution.user.service.userservice.service.impl;

import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import com.codeforsolution.user.service.userservice.service.JwtService;
import com.codeforsolution.user.service.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;


    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    /**
     * @param token
     */
    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
