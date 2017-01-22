package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountGroup;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public interface IAccountGroupDao {

    /**
     * Return accountGroup object that matches the uuid passed in as parameter
     * @param uuid - the uuid of the account group object to be returned
     * @return @see AccountGroup.class
     */
    AccountGroup getAccountGroupByUUID(String uuid);


    /**
     * Persists a new AccountGroup object to storage
     * @param accountGroup - the object of type AccountGroup to be saved
     * @return the saved AccountGroup
     */
    AccountGroup createAccountGroup(AccountGroup accountGroup);

    /**
     * Updates the passed AccountGroup in storage
     * @param accountGroup - the object of type AccountGroup to be saved
     * @return the saved AccountGroup
     */
    AccountGroup saveAccountGroup(AccountGroup accountGroup);
}
