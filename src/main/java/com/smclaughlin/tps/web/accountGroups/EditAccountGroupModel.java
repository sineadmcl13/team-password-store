package com.smclaughlin.tps.web.accountGroups;

import com.smclaughlin.tps.entities.AccountGroup;
import com.smclaughlin.tps.web.AbstractModel;

import java.io.Serializable;

/**
 * Created by sineadmclaughlin on 23/01/2017.
 */
public class EditAccountGroupModel extends AbstractModel implements Serializable{


    public final static String KEY = "editAccountGroupModel";
    private static final long serialVersionUID = -3234509632009486969L;


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
