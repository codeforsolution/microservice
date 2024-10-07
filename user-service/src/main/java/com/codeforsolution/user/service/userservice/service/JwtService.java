package com.codeforsolution.user.service.userservice.service;

public interface JwtService {

    public String  generateToken(String username);
    public void validateToken(String token);
}
