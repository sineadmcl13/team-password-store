package com.smclaughlin.tps.service;

import com.smclaughlin.tps.repos.IAccountGroupRepo;
import com.smclaughlin.tps.entities.AccountGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Service
public class AccountGroupService implements IAccountGroupService {


    @Autowired
    IAccountGroupRepo accountGroupRepo;

    @Override
    public AccountGroup getAccountDetailsByUUID(String uuid) {
        return accountGroupRepo.findByUuid(uuid);
    }


    @Override
    public AccountGroup saveAccountGroup(AccountGroup accountGroup) {
        return accountGroupRepo.save(accountGroup);
    }
}
