package com.smclaughlin.tps.web.dashboard;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sineadmclaughlin on 23/11/2016.
 */
public class DashboardTestController extends IntegrationTest {

    @Test
    public void testDashboardView() throws Exception{
        mockMvc.perform(get("/dashboard"))
                .andExpect(view().name("dashboard/dashboard"));
    }


    @Test
    @DatabaseSetup("/test_db/web/dashboard/beforeTestDashboardModel.xml")
    @DatabaseTearDown
    public void testDashboardModelReset() throws Exception{

        DashboardModel modelResult =
                (DashboardModel) mockMvc.perform(get("/dashboard"))
                        .andReturn().getModelAndView().getModelMap().get(DashboardModel.KEY);

        List<AccountDetails> accountDetailsList = modelResult.getAccountDetailsList();
        assertThat(accountDetailsList, contains(createTestAccountDetail()));
    }


    @Test
    @DatabaseSetup("/test_db/web/dashboard/beforeTestDisplayAccountPassword.xml")
    @DatabaseTearDown
    public void testDisplayAccountPassword() throws Exception{

        String result = mockMvc.perform(get("/account/password/d8b50f71-a69f-4710-a6cf-d0bc8f328e9a"))
                        .andReturn().getResponse().getContentAsString();

        assertThat(result, equalTo("decryptPassword"));
    }




}
