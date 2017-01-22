package com.smclaughlin.tps.web.accountGroups;

import com.smclaughlin.tps.entities.AccountGroup;
import com.smclaughlin.tps.web.AbstractModel;

import java.io.Serializable;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public class AddAccountGroupModel extends AbstractModel implements Serializable{


    public final static String KEY = "addAccountGroupModel";
    private static final long serialVersionUID = 7040574067880094041L;


    private AccountGroup accountGroup;

    @Override
    public void reset() {
        this.accountGroup = new AccountGroup();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }
}
