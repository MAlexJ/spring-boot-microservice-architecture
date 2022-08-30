package com.malexj.services;

import com.malexj.models.AesRequest;
import com.malexj.models.AesResponse;

public interface AesEncryptService {

    @Deprecated
    String encrypt(AesRequest request);

    AesResponse encrypt(String stringToEncode);

    String decrypt(String encodedString, String key);
}
