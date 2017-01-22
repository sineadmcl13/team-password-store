package com.smclaughlin.tps.entities;

import com.smclaughlin.tps.utils.AbstractPojoTester;

/**
 * Created by sineadmclaughlin on 26/11/2016.
 */
public class GroupsTest extends AbstractPojoTester<AccountGroup> {

    @Override
    protected AccountGroup getPojoInstance() {
        return new AccountGroup();
    }
}
