package com.smclaughlin.tps.entities;

import com.smclaughlin.tps.utils.AbstractPojoTester;

/**
 * Created by sineadmclaughlin on 26/11/2016.
 */
public class AccountDetailsTest extends AbstractPojoTester<AccountDetails> {

    @Override
    protected AccountDetails getPojoInstance() {
        return new AccountDetails();
    }
}
