package com.smclaughlin.tps.service;

import com.smclaughlin.tps.repos.IAccountDetailsRepo;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.security.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sineadmclaughlin on 25/11/2016.
 */
@Service
public class AccountDetailsService implements IAccountDetailsService {


    @Autowired
    IPasswordService passwordService;

    @Autowired
    IAccountDetailsRepo accountDetailsRepo;

    @Override
    public AccountDetails getAccountDetailsByUUID(String uuid) {
        return accountDetailsRepo.findByUuid(uuid);
    }

    @Override
    public List<AccountDetails> returnListOfAccountDetails() {
        Iterable<AccountDetails> source = accountDetailsRepo.findAll();
        List<AccountDetails> list = new ArrayList<>();
        source.forEach(list::add);
        return list;
    }

    @Override
    public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
        securePasswordDetails(accountDetails);
        return accountDetailsRepo.save(accountDetails);
    }


    private AccountDetails securePasswordDetails(AccountDetails ad){
        String salt = passwordService.generatePasswordSalt();
        String hash = passwordService.generateHash(salt, ad.getPasswordHash());
        ad.setPasswordSalt(salt);
        ad.setPasswordHash(hash);
        return ad;
    }

}
