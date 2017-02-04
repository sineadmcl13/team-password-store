package com.smclaughlin.tps.pojos;

import com.smclaughlin.tps.utils.AbstractPojoTester;

/**
 * Created by sineadmclaughlin on 04/02/2017.
 */
public class UserPojoTest extends AbstractPojoTester<UserPojo> {

    @Override
    protected UserPojo getPojoInstance() {
        return new UserPojo();
    }
}
