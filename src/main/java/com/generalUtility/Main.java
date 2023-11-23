package com.generalUtility;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String encrptData= "U2hhcmFkQDIwMjM=";
//        byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());
//        System.out.println(new String(encodedBytes));
        String decodeBytes = new String (Base64.getDecoder().decode(encrptData.getBytes()));
        System.out.println(decodeBytes);
    }
}
