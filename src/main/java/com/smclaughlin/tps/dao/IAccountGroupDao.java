package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountGroup;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public interface IAccountGroupDao {

    /**
     * Persists a new AccountGroup object to storage
     * @param accountGroup - the object of type AccountGroup to be saved
     * @return the saved AccountGroup
     */
    AccountGroup createGroup(AccountGroup accountGroup);
}
