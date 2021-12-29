package com.malexj.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class AesRequest {
    @NonNull
    private String stringToEncrypt;
    @NonNull
    private String secret;
}
