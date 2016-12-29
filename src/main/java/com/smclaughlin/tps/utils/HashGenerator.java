package com.smclaughlin.tps.utils;

import com.lambdaworks.crypto.SCryptUtil;

/**
 * Created by sineadmclaughlin on 11/12/2016.
 */
@FunctionalInterface
public interface HashGenerator {

    static String generateHash(String passwd) {
        int N = 16384;
        int r = 8;
        int p = 1;
        return SCryptUtil.scrypt(passwd, N, r, p);
    }

    String customGenerateHash();
}
