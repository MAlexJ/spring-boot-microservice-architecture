package com.malexj.services.impl;

import com.malexj.exceptions.AesException;
import com.malexj.exceptions.AesValidationException;
import com.malexj.models.AesRequest;
import com.malexj.services.AesEncryptService;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public abstract class AesEncryptServiceDeprecated implements AesEncryptService {

    private static final String ALG_TYPE = "AES";
    private static final String ALG_MODE = "CBC";
    private static final String ALG_PAD = "PKCS5Padding";

    private static final String ALG_TEMPLATE = "%s/%s/%s";

    public static final String MESSAGE_DIGEST_MD_5 = "MD5";

    @Override
    public String encrypt(AesRequest request) {
        String secret = request.getSecret();
        String stringToEncrypt = request.getStringToEncrypt();

        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[8];
        sr.nextBytes(salt);

        final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, salt, secret.getBytes(StandardCharsets.UTF_8));
        byte[] encryptedData = getBytesFormCipher(stringToEncrypt, keyAndIV);
        byte[] prefixAndSaltAndEncryptedData = new byte[16 + encryptedData.length];

        // Copy prefix (0-th to 7-th bytes)
        System.arraycopy("Salted__".getBytes(StandardCharsets.UTF_8), 0, prefixAndSaltAndEncryptedData, 0, 8);
        // Copy salt (8-th to 15-th bytes)
        System.arraycopy(salt, 0, prefixAndSaltAndEncryptedData, 8, 8);
        // Copy encrypted data (16-th byte and onwards)
        System.arraycopy(encryptedData, 0, prefixAndSaltAndEncryptedData, 16, encryptedData.length);
        return Base64.getEncoder().encodeToString(prefixAndSaltAndEncryptedData);
    }

    private byte[] getBytesFormCipher(String stringToEncrypt, byte[][] keyAndIV) {
        try {
            // 1. verification
            verificationKeyAndIV(keyAndIV);

            // 2. create KEY + IV setting
            IvParameterSpec ivParameterSpec = new IvParameterSpec(keyAndIV[1]);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyAndIV[0], ALG_TYPE);

            // 3. init Cipher
            Cipher cipher = Cipher.getInstance(String.format(ALG_TEMPLATE, ALG_TYPE, ALG_MODE, ALG_PAD));
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(stringToEncrypt.getBytes(StandardCharsets.UTF_8));
        } catch (GeneralSecurityException e) {
            throw new AesException(e.getMessage(), e);
        }
    }

    private void verificationKeyAndIV(byte[][] keyAndIV) {
        if (keyAndIV == null) {
            throw new AesValidationException("Secret key or IV should not null!");
        }
        if (keyAndIV[0] == null) {
            throw new AesValidationException("Secret key is null!");
        }
        if (keyAndIV[1] == null) {
            throw new AesValidationException("IV is null!");
        }
    }

    private MessageDigest getMessageDigestMd5() {
        try {
            return MessageDigest.getInstance(MESSAGE_DIGEST_MD_5);
        } catch (NoSuchAlgorithmException e) {
            throw new AesException(e.getMessage(), e);
        }
    }

    public byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password) {
        MessageDigest md = getMessageDigestMd5();
        int digestLength = md.getDigestLength();
        int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
        byte[] generatedData = new byte[requiredLength];
        int generatedLength = 0;
        try {
            md.reset();
            // Repeat process until sufficient data has been generated
            while (generatedLength < keyLength + ivLength) {

                // Digest data (last digest if available, password data, salt if available)
                if (generatedLength > 0) md.update(generatedData, generatedLength - digestLength, digestLength);
                md.update(password);
                if (salt != null) md.update(salt, 0, 8);
                md.digest(generatedData, generatedLength, digestLength);

                // additional rounds
                for (int i = 1; i < iterations; i++) {
                    md.update(generatedData, generatedLength, digestLength);
                    md.digest(generatedData, generatedLength, digestLength);
                }
                generatedLength += digestLength;
            }

            // Copy key and IV into separate byte arrays
            byte[][] result = new byte[2][];
            result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
            if (ivLength > 0) {
                result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);
            }
            return result;
        } catch (DigestException e) {
            throw new AesException(e.getMessage(), e);
        } finally {
            // Clean out temporary data
            Arrays.fill(generatedData, (byte) 0);
            // reset MessageDigest
            md.reset();
        }
    }
}
