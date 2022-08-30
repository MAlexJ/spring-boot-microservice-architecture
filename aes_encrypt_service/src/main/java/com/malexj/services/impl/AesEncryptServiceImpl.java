package com.malexj.services.impl;

import com.malexj.models.AesResponse;
import org.springframework.stereotype.Service;

/**
 * Java AES Encryption and Decryption
 * link: https://www.baeldung.com/java-aes-encryption-decryption
 */
@Service
public class AesEncryptServiceImpl extends AesEncryptServiceDeprecated {

    @Override
    public AesResponse encrypt(String input) {
        return null;
    }

    @Override
    public String decrypt(String encodedString, String key) {
        return null;
    }

}
