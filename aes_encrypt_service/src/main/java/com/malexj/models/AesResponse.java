package com.malexj.models;

import lombok.Data;

@Data
public class AesResponse {
    private String encodedString;
    private String key;
}
