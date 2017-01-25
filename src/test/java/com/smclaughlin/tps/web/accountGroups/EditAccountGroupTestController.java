package com.smclaughlin.tps.web.accountGroups;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountGroup;
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
public class EditAccountGroupTestController extends IntegrationTest{

    @Test
    @DatabaseSetup("/test_db/web/accountGroups/beforeEditAccountGroupTest.xml")
    public void testEditAccountGroupView() throws Exception{
        mockMvc.perform(get("/edit/account-group/38a5639e-d041-4793-bfce-bccf81016e38"))
                .andExpect(view().name("group/editGroup"));
    }

    @Test
    @DatabaseSetup("/test_db/web/accountGroups/beforeEditAccountGroupTest.xml")
    public void testEditAccountGroupModelReset() throws Exception{
        EditAccountGroupModel modelResult =
                (EditAccountGroupModel) mockMvc.perform(get("/edit/account-group/38a5639e-d041-4793-bfce-bccf81016e38"))
                        .andReturn().getModelAndView().getModelMap().get(EditAccountGroupModel.KEY);

        AccountGroup accountGroup = modelResult.getAccountGroup();
        assertEquals(accountGroup, createTestAccountGroupDetails());

    }

    @Test
    public void checkAccountModelKeyIsNotNull() throws Exception{
        assertNotNull(new EditAccountGroupModel().getKey());
    }

    @Test
    @DatabaseSetup("/test_db/web/accountGroups/beforeEditAccountGroupTest.xml")
    public void testEditAccountGroupPost() throws Exception{

        AccountGroup accountGroup = createTestAccountGroupDetails();

        EditAccountGroupModel model = new EditAccountGroupModel();
        model.setAccountGroup(accountGroup);

        mockMvc.perform(post("/edit/account-group/38a5639e-d041-4793-bfce-bccf81016e38").sessionAttr(EditAccountGroupModel.KEY, model))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dashboard"))
                .andExpect(flash().attributeExists(FLASH_MESSAGE));
    }

}
