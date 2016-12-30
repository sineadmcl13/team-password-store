package com.smclaughlin.tps.service;

import com.smclaughlin.tps.dao.IAccountDetailsDao;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.security.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sineadmclaughlin on 25/11/2016.
 */
@Service
public class AccountDetailsService implements IAccountDetailsService {

    @Autowired
    IAccountDetailsDao accountDetailsDao;

    @Autowired
    IPasswordService passwordService;

    @Override
    public AccountDetails getAccountDetailsByUUID(String uuid) {
        return accountDetailsDao.getAccountDetailsByUUID(uuid);
    }

    @Override
    public List<AccountDetails> returnListOfAccountDetails() {
        return accountDetailsDao.getListOfAccountDetails();
    }

    @Override
    public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
        securePasswordDetails(accountDetails);
        return accountDetailsDao.saveAccountDetails(accountDetails);
    }

    @Override
    public AccountDetails createNewAccountDetails(AccountDetails accountDetails) {
        securePasswordDetails(accountDetails);
        return accountDetailsDao.createNewAccountDetails(accountDetails);
    }


    private AccountDetails securePasswordDetails(AccountDetails ad){
        String salt = passwordService.generatePasswordSalt();
        String hash = passwordService.generateHash(salt, ad.getPasswordHash());
        ad.setPasswordSalt(salt);
        ad.setPasswordHash(hash);
        return ad;
    }

}
