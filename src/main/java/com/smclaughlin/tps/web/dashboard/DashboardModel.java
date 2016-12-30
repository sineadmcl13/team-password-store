package com.smclaughlin.tps.web.dashboard;

import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.web.AbstractModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sineadmclaughlin on 27/11/2016.
 */
public class DashboardModel extends AbstractModel implements Serializable{


    public final static String KEY = "dashboardModel";
    private static final long serialVersionUID = 8065753207492818684L;

    private List<AccountDetails> accountDetailsList;

    @Override
    public void reset() {
        this.accountDetailsList = new ArrayList<>();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    public List<AccountDetails> getAccountDetailsList() {
        return accountDetailsList;
    }

    public void setAccountDetailsList(List<AccountDetails> accountDetailsList) {
        this.accountDetailsList = accountDetailsList;
    }
}
