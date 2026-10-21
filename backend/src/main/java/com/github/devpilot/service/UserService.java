package com.github.devpilot.service;

import com.github.devpilot.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    public User getUserById(UUID id);

    public String decryptAccessToken(User user);
}
