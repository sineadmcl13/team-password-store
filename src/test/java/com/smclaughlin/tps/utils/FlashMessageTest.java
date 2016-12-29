package com.smclaughlin.tps.utils;

/**
 * Created by sineadmclaughlin on 26/11/2016.
 */
public class FlashMessageTest extends AbstractPojoTester<FlashMessage> {

    @Override
    protected FlashMessage getPojoInstance() {
        return new FlashMessage();
    }

    @Override
    public void setCheckEquals() {
        checkEquals = false;
    }
}
