package com.smclaughlin.tps.web.accounts;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import org.junit.Test;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sineadmclaughlin on 27/11/2016.
 */
public class EditAccountTestController extends IntegrationTest{

    @Test
    @DatabaseSetup("/test_db/web/accounts/beforeEditAccountViewTest.xml")
    public void testEditAccountView() throws Exception{
        mockMvc.perform(get("/edit/account/38a5639e-d041-4793-bfce-bccf81016e38"))
                .andExpect(view().name("accounts/editAccount"));
    }

    @Test
    @DatabaseSetup("/test_db/web/accounts/beforeEditAccountViewTest.xml")
    public void testEditAccountModelReset() throws Exception{
        EditAccountModel modelResult =
                (EditAccountModel) mockMvc.perform(get("/edit/account/38a5639e-d041-4793-bfce-bccf81016e38"))
                        .andReturn().getModelAndView().getModelMap().get(EditAccountModel.KEY);

        AccountDetails accountDetails = modelResult.getAccountDetails();
        assertEquals(accountDetails, createTestAccountDetail());

    }

    @Test
    public void checkAccountModelKeyIsNotNull() throws Exception{
        assertNotNull(new EditAccountModel().getKey());
    }

    @Test
    @DatabaseSetup("/test_db/web/accounts/beforeEditAccountViewTest.xml")
    public void testEditAccountPost() throws Exception{

        AccountDetails accountDetails = createTestAccountDetail();

        EditAccountModel model = new EditAccountModel();
        model.setAccountDetails(accountDetails);

        mockMvc.perform(post("/edit/account/38a5639e-d041-4793-bfce-bccf81016e38").sessionAttr(EditAccountModel.KEY, model))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dashboard"))
                .andExpect(flash().attributeExists(FLASH_MESSAGE));
    }

}
