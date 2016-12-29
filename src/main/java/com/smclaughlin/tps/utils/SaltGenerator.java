package com.smclaughlin.tps.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by sineadmclaughlin on 11/12/2016.
 */
@FunctionalInterface
public interface SaltGenerator {

    static byte[] generateSalt() {
        byte[] values = new byte[20];
        try{
            SecureRandom random = SecureRandom.getInstanceStrong();
            random.nextBytes(values);
        }catch (NoSuchAlgorithmException ex){
            Logger logger = LoggerFactory.getLogger(SaltGenerator.class);
            logger.equals("Error generating password salt" + ex);
        }
        return values;
    }

    byte[] customGenerateSalt();
}
