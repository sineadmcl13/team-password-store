package com.smclaughlin.tps.utils;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by sineadmclaughlin on 26/11/2016.
 */
public abstract class AbstractPojoTester<T> {

    protected abstract T getPojoInstance();

    protected boolean checkEquals;

    @Before
    public void setCheckEquals() {
        this.checkEquals = true;
    }

    class LocalDateTimeFactory implements Factory {
        @Override
        public LocalDateTime create() {
            return LocalDateTime.now();
        }
    }


    @Test
    public void getterAndSetterCorrectness() throws Exception {
        final BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(getPojoInstance().getClass());
    }

    @Test
    public void beanIsSerializable() throws Exception {
        final T myBean = getPojoInstance();

        if(myBean instanceof Serializable){
            final byte[] serializedMyBean = SerializationUtils.serialize(myBean);
            @SuppressWarnings("unchecked")
            final T deserializedMyBean = (T) SerializationUtils.deserialize(serializedMyBean);
            assertEquals(myBean, deserializedMyBean);
        }
    }

}
