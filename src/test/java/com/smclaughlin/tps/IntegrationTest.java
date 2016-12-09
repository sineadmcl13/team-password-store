package com.smclaughlin.tps;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by sineadmclaughlin on 22/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public abstract class IntegrationTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;
    protected String ABSOLUTE_PATH = "http://localhost/";

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }
}
