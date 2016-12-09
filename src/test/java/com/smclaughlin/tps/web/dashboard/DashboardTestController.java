package com.smclaughlin.tps.web.dashboard;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sineadmclaughlin on 23/11/2016.
 */
public class DashboardTestController extends IntegrationTest {

    @Test
    @WithMockUser(username="user", roles = "USER")
    public void testDashboardView() throws Exception{
        mockMvc.perform(get("/home"))
                .andExpect(view().name("home/dashboard"));
    }


    @Test
    @WithMockUser(username="user", roles = "USER")
    @DatabaseSetup("/test_db/dashboard/beforeTestDashboardModel.xml")
    @DatabaseTearDown
    public void testDashboardModel() throws Exception{

        AccountDetails accountDetails = new AccountDetails(1L, "testAccount", "google.com", "admin@test.com", "password", "password");

        mockMvc.perform(get("/home"))
                .andExpect(model().attribute("account_details", equalTo(accountDetails)));

    }
}
