package com.company;
import org.apache.commons.codec.digest.DigestUtils;

public class SecureCode {

    public static String getKey(byte[] values) {
        StringBuilder stringKey = new StringBuilder();
        for (byte k : values) {
            stringKey.append(String.format("%02X", k));
        }
        return stringKey.toString();
    }

    public static String getHex(String value) {
        return new DigestUtils("SHA3-256").digestAsHex(value);
    }
}
