package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountDetails;

import java.util.List;

/**
 * Created by sineadmclaughlin on 25/11/2016.
 */
public interface IAccountDetailsDao {

    /**
     * Return accountDetails object that matches the id passed in as parameter
     * @param uuid - the uuid of the account details object to be returned
     * @return @see AccountDetails.class
     */
    AccountDetails getAccountDetailsByUUID(String uuid);


    /**
     * Returns a list of Account Details objects
     * @return List of Account Details objects
     */
    List<AccountDetails> getListOfAccountDetails();


    /**
     * Persists a new AccountDetails object to storage
     * @param accountDetails - the object of type AccountDetails to be saved
     * @return the saved AccountDetails
     */
    AccountDetails createNewAccountDetails(AccountDetails accountDetails);

    /**
     * Updates the passed AccountDetails to storage
     * @param accountDetails - the object of type AccountDetails to be saved
     * @return the saved AccountDetails
     */
    AccountDetails saveAccountDetails(AccountDetails accountDetails);
}
