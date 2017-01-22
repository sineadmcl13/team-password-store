package com.smclaughlin.tps.service;

import com.smclaughlin.tps.entities.AccountGroup;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public interface IAccountGroupService {


    /**
     * Persists a new AccountGroup object to storage
     * @param accountGroup - the object of type AccountGroup to be saved
     * @return the saved accountGroup
     */
    AccountGroup createNewAccountGroup(AccountGroup accountGroup);

}
