package com.smclaughlin.tps.service.security;

import com.smclaughlin.tps.entities.AccountDetails;

/**
 * Created by sineadmclaughlin on 29/12/2016.
 */
public interface IPasswordService {

    byte[] generatePasswordSalt();

    String generateHash(String salt, String passwd);
}
