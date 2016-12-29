package com.smclaughlin.tps.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.Base64;
/**
 * Created by sineadmclaughlin on 11/12/2016.
 */
public class CipherGenerator {

    private static String INIT_VECTOR = "Te7PrzS1n5tV0cOr";

    private static String CIPHER_ENCRYPT_MODE="AES/CBC/PKCS5PADDING";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String encrypt(String key, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(INIT_VECTOR.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance(CIPHER_ENCRYPT_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal((key+value).getBytes());

            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(INIT_VECTOR.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance(CIPHER_ENCRYPT_MODE);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);


            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original).split(key)[1];
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


}
