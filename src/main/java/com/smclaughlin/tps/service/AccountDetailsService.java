package com.smclaughlin.tps.service;

import com.smclaughlin.tps.dao.IAccountDetailsDao;
import com.smclaughlin.tps.entities.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 25/11/2016.
 */
@Service
public class AccountDetailsService implements IAccountDetailsService {

    @Autowired
    IAccountDetailsDao accountDetailsDao;

    @Override
    public AccountDetails getAccountDetailsById(Long id) {
        return accountDetailsDao.getAccountDetailsById(id);
    }
}
