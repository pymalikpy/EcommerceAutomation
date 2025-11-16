package org.nopcommerce.com.Utilities;

import java.security.SecureRandom;
import java.util.logging.Logger;

public class RandomUtils {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String ALPHANUMERIC = LETTERS+DIGITS;
    private static Logger logger;


    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomFromCharset(int length, String charset){
        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i<length; i++){
            int index = random.nextInt(charset.length());
            sb.append(charset.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomAlphaNumericString(int length){
        return generateRandomFromCharset(length,ALPHANUMERIC);
    }
    public static String generateRandomAlphaString(int length){
        return generateRandomFromCharset(length,LETTERS);
    }
    public static String generateRandomNumericString(int length){
        return generateRandomFromCharset(length,DIGITS);
    }
}
