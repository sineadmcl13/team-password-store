package com.smclaughlin.tps.web.entities;

import com.smclaughlin.tps.entities.AccountDetails;

/**
 * Created by sineadmclaughlin on 26/11/2016.
 */
public class AccountDetailsTest extends AbstractPojoTester<AccountDetails> {

    @Override
    protected AccountDetails getPojoInstance() {
        return new AccountDetails();
    }
}
