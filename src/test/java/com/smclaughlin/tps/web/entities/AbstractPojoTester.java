package com.smclaughlin.tps.web.entities;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
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

    class LocalDateTimeFactory implements Factory {
        @Override
        public LocalDateTime create() {
            return LocalDateTime.now();
        }
    }

    @Test
    public void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(getPojoInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
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
