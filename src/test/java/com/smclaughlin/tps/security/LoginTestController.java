package com.smclaughlin.tps.security;

import com.smclaughlin.tps.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sineadmclaughlin on 22/11/2016.
 */
public class LoginTestController extends IntegrationTest {

    @Override
    @Before
    public void setup(){
        mockMvc= MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void redirectToLoginWhenNotAuthenticated() throws Exception{
        mockMvc.perform(get("/dashboard"))
                .andExpect(status().is3xxRedirection())
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl(ABSOLUTE_PATH+"login"));
    }


    @Test
    public void testInValidLoginDetails() throws Exception{
        mockMvc.perform(formLogin("/login")
                .user("user")
                .password("password2"))
                .andExpect(status().is3xxRedirection())
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    public void testValidLoginDetails() throws Exception{
        mockMvc.perform(formLogin("/login")
                .user("user")
                .password("password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(authenticated().withRoles("USER"))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    @WithMockUser(username="user", roles = "USER")
    public void testLoginPage() throws Exception{

        mockMvc.perform(get("/login"))
                .andExpect(view().name("login"));

    }

    @Test
    @WithMockUser(username="user", roles = "USER")
    public void testOnRootRequest() throws Exception{

        mockMvc.perform(get("/"))
                .andExpect(redirectedUrl("/dashboard"))
                .andExpect(view().name("redirect:/dashboard"));

    }

    @Test
    @WithMockUser(username="user", roles = "USER")
    public void testLogout() throws Exception{

        mockMvc.perform(get("/logout"))
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/login?logout"));

    }

}
