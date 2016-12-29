package com.smclaughlin.tps.service.security;


/**
 * Created by sineadmclaughlin on 29/12/2016.
 */
public interface IPasswordService {

    String generatePasswordSalt();

    String generateHash(String salt, String passwd);

    String returnUnEncryptedPasswordFromAccountByUUID(String uuid);
}

