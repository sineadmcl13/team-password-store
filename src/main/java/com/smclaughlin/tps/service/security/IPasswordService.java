package com.smclaughlin.tps.service.security;


/**
 * Created by sineadmclaughlin on 29/12/2016.
 */
public interface IPasswordService {

    /**
     * Returns a randomly generated string to be used as a salt or encryption key
     * @return a string of 16 randomly generated chars
     */
    String generatePasswordSalt();

    /**
     * Generate an encrypted version of the password using the randomly generated salt or encryption key
     * @param salt the randomly generated 16 char salt
     * @param passwd the password to be encrypted
     * @return returns an encrypted version of the plain text password parameter
     */
    String generateHash(String salt, String passwd);

    /**
     * Returns the password in plain text from the account details object referenced by the uuid
     * @param uuid the uuid of the account details object
     * @return the password stored against the account details in plain text
     */
    String returnUnEncryptedPasswordFromAccountByUUID(String uuid);
}

