package com.smclaughlin.tps.service.security;

import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.IAccountDetailsService;
import com.smclaughlin.tps.utils.CipherGenerator;
import com.smclaughlin.tps.utils.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 29/12/2016.
 */
@Service
public class PasswordService implements IPasswordService {

    @Autowired
    IAccountDetailsService accountDetailsService;

    @Override
    public String generatePasswordSalt() {
        return SaltGenerator.generateSalt();
    }

    @Override
    public String generateHash(String salt, String passwd) {
        return CipherGenerator.encrypt(salt, passwd);
    }

    @Override
    public String returnUnEncryptedPasswordFromAccountByUUID(String uuid) {
        AccountDetails ad = accountDetailsService.getAccountDetailsByUUID(uuid);
        return CipherGenerator.decrypt(ad.getPasswordSalt(), ad.getPasswordHash());
    }
}
