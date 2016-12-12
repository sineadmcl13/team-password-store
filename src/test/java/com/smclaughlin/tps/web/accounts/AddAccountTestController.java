package com.smclaughlin.tps.web.accounts;

import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import static com.smclaughlin.tps.utils.SystemEnums.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by sineadmclaughlin on 27/11/2016.
 */
public class AddAccountTestController extends IntegrationTest{

    @Test
    public void testAddAccountView() throws Exception{
        mockMvc.perform(get("/add/account"))
                .andExpect(view().name("accounts/addAccount"));
    }

    @Test
    public void testAddAccountModelReset() throws Exception{
        AddAccountModel modelResult =
                (AddAccountModel) mockMvc.perform(get("/add/account"))
                        .andReturn().getModelAndView().getModelMap().get(AddAccountModel.KEY);

        AccountDetails accountDetails = modelResult.getAccountDetails();
        assertEquals(accountDetails, new AccountDetails());

    }

    @Test
    public void checkAccountModelKeyIsNotNull() throws Exception{
        assertNotNull(new AddAccountModel().getKey());
    }

    @Test
    public void testAddAccountPost() throws Exception{

        AddAccountModel model = new AddAccountModel();
        model.setAccountDetails(createTestAccountDetail());

        mockMvc.perform(post("/add/account").sessionAttr(AddAccountModel.KEY, model))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/home"))
                .andExpect(flash().attribute(FLASH_MESSAGE.name(), "success"));
    }



}
