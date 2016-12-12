package com.smclaughlin.tps.web.accounts;

import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.web.AbstractModel;

import java.io.Serializable;

/**
 * Created by sineadmclaughlin on 27/11/2016.
 */
public class EditAccountModel extends AbstractModel implements Serializable{


    public final static String KEY = "editAccountsModel";
    private static final long serialVersionUID = 8065753207492818684L;

    private AccountDetails accountDetails;

    @Override
    public void reset() {
        this.accountDetails = new AccountDetails();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }
}
