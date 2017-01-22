package com.smclaughlin.tps.service;

import com.smclaughlin.tps.dao.IAccountGroupDao;
import com.smclaughlin.tps.entities.AccountGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Service
public class AccountAccountGroupService implements IAccountGroupService {

    @Autowired
    IAccountGroupDao groupDao;


    @Override
    public AccountGroup getAccountDetailsByUUID(String uuid) {
        return groupDao.getAccountGroupByUUID(uuid);
    }

    @Override
    public AccountGroup createNewAccountGroup(AccountGroup accountGroup) {
        return groupDao.createAccountGroup(accountGroup);
    }

    @Override
    public AccountGroup saveAccountGroup(AccountGroup accountGroup) {
        return groupDao.saveAccountGroup(accountGroup);
    }
}
