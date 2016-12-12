package com.smclaughlin.tps.web.dashboard;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sineadmclaughlin on 23/11/2016.
 */
public class DashboardTestController extends IntegrationTest {

    @Test
    public void testDashboardView() throws Exception{
        mockMvc.perform(get("/home"))
                .andExpect(view().name("home/dashboard"));
    }


    @Test
    @DatabaseSetup("/test_db/web/dashboard/beforeTestDashboardModel.xml")
    @DatabaseTearDown
    public void testDashboardModelReset() throws Exception{

        DashboardModel modelResult =
                (DashboardModel) mockMvc.perform(get("/home"))
                        .andReturn().getModelAndView().getModelMap().get(DashboardModel.KEY);

        List<AccountDetails> accountDetailsList = modelResult.getAccountDetailsList();
        assertEquals(accountDetailsList, new ArrayList<AccountDetails>());

    }
}
