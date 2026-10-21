package com.github.devpilot.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUtil {
    private TextEncryptor tokenEncryptor;

    public String decryptUserAccessToken(String accessToken){
        return tokenEncryptor.decrypt(accessToken);
    }


}
