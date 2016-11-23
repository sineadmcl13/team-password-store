package com.smclaughlin.tps;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by sineadmclaughlin on 22/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
