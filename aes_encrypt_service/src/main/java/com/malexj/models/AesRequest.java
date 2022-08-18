package com.malexj.models;

import lombok.Data;
import lombok.NonNull;

/**
 * Request body:
 * {
 *     "stringToEncrypt":"BASE64_text",
 *     "secret":"MY_SECRET"
 * }
 */
@Data
public class AesRequest {
    @NonNull
    private String stringToEncrypt;
    @NonNull
    private String secret;
}
