package com.codeforsolution.user.service.userservice.controller;

import com.codeforsolution.user.service.userservice.config.AuthConfig;
import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.model.UserRequest;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import com.codeforsolution.user.service.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {


    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + id));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUsers(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    @PostMapping("/token")
    public String getToken(@RequestBody UserRequest user){
        logger.info("---- get token method called--------");
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authenticate.isAuthenticated()) {
            return userService.generateToken(user.getUsername());
        }else {
            throw new RuntimeException("Invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
         userService.validateToken(token);
         return "valid token";
    }

}
