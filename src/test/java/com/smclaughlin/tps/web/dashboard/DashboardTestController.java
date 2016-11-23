package com.smclaughlin.tps.web.dashboard;

import com.smclaughlin.tps.IntegrationTest;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sineadmclaughlin on 23/11/2016.
 */
public class DashboardTestController extends IntegrationTest {


    @Test
    @WithMockUser(username="user", roles = "USER")
    public void testLogout() throws Exception{

        mockMvc.perform(get("/home"))
                .andExpect(view().name("home/dashboard"))
                .andExpect(model().attribute("name", "World"));

    }

}
