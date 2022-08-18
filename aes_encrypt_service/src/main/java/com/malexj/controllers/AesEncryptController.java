package com.malexj.controllers;

import com.malexj.exceptions.AesException;
import com.malexj.exceptions.AesValidationException;
import com.malexj.models.AesRequest;
import com.malexj.models.ErrorResponse;
import com.malexj.services.AesEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/v1/aes")
public class AesEncryptController {

    private final AesEncryptService service;

    @PostMapping
    public String encrypt(@RequestBody AesRequest request) {
        return service.encrypt(request);
    }

    @ExceptionHandler({AesValidationException.class, AesException.class})
    public ResponseEntity<ErrorResponse> handleAesExceptions(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }

}
