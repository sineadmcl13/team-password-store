package com.smclaughlin.tps.service;

import com.smclaughlin.tps.entities.AccountGroup;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public interface IAccountGroupService {


    /**
     * Return accountGroup object that matches the id passed in as parameter
     * @param uuid - the uuid of the account details object to be returned
     * @return @see AccountDetails.class
     */
    AccountGroup getAccountDetailsByUUID(String uuid);


    /**
     * Persists the passed AccountGroup to the db
     * @param accountGroup - the object of type AccountGroup to be saved
     * @return the saved AccountGroup
     */
    AccountGroup saveAccountGroup(AccountGroup accountGroup);
}
