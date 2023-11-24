package com.generalUtility;

import java.util.Base64;

public class EncryptDecrypt {

    private EncryptDecrypt() {

    }

    public static String encryption(String password) {
        byte[] encrypt = password.getBytes();
        return Base64.getEncoder().encodeToString(encrypt);
    }

    public static String decryption(String password) {
        byte[] decrypt = Base64.getDecoder().decode(password);
        return new String(decrypt);
    }
}
