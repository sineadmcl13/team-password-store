package com.smclaughlin.tps.entities;

import com.smclaughlin.tps.utils.AbstractPojoTester;

/**
 * Created by sineadmclaughlin on 20/01/2017.
 */
public class UserTest extends AbstractPojoTester<User> {

    @Override
    protected User getPojoInstance() {
        return new User();
    }
}
