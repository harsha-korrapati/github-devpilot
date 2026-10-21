package com.github.devpilot.service;

import com.github.devpilot.entity.User;
import com.github.devpilot.exception.NotFoundException;
import com.github.devpilot.repository.UserRepository;
import com.github.devpilot.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private TextEncryptor tokenEncryptor;
    private UserUtil userUtil;

    @Override
    @Transactional(readOnly = true)
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found with this id :"+id));
    }

    @Override
    public String decryptAccessToken(User user) {
        return userUtil.decryptUserAccessToken(user.getAccessToken());
    }


    private Long toLong(Object value){
        if(value instanceof Number number){
            return number.longValue();
        }
        return Long.parseLong(String.valueOf(value));
    }
}
