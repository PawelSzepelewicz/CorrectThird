package com.company;
import org.apache.commons.codec.digest.DigestUtils;

public class SecureCode {

    public static String getHex(byte[] values) {
        return new DigestUtils("SHA3-256").digestAsHex(values);
    }

    public static String getHex(String value) {
        return new DigestUtils("SHA3-256").digestAsHex(value);
    }
}
