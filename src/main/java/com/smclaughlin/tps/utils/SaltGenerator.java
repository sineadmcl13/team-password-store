package com.smclaughlin.tps.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by sineadmclaughlin on 11/12/2016.
 */
public class SaltGenerator {

    private static char[] VALID_CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();

    public static String generateSalt() {
        SecureRandom srand = new SecureRandom();
        Random rand = new Random();
        char[] buff = new char[16];

        for (int i = 0; i < 16; ++i) {
            // reseed rand once you've used up all available entropy bits
            if ((i % 10) == 0) {
                rand.setSeed(srand.nextLong()); // 64 bits of random!
            }
            buff[i] = VALID_CHARACTERS[rand.nextInt(VALID_CHARACTERS.length)];
        }
        return new String(buff);
    }

}
