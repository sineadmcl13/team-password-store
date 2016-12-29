package com.smclaughlin.tps.service.security;

import com.smclaughlin.tps.utils.HashGenerator;
import com.smclaughlin.tps.utils.SaltGenerator;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 29/12/2016.
 */
@Service
public class PasswordService implements IPasswordService {

    @Override
    public byte[] generatePasswordSalt() {
        return SaltGenerator.generateSalt();
    }

    @Override
    public String generateHash(String salt, String passwd) {
        return HashGenerator.generateHash(salt+passwd);
    }
}
