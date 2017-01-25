package com.smclaughlin.tps.web.accountGroups;

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
 * Created by sineadmclaughlin on 22/01/2017.
 */
public class AddGroupTestController extends IntegrationTest{

    @Test
    public void testAddGroupView() throws Exception{
        mockMvc.perform(get("/add/account-group"))
                .andExpect(view().name("group/addGroup"));
    }

    @Test
    public void testAddAccountModelReset() throws Exception{
        AddAccountGroupModel modelResult =
                (AddAccountGroupModel) mockMvc.perform(get("/add/account-group"))
                        .andReturn().getModelAndView().getModelMap().get(AddAccountGroupModel.KEY);

        AccountGroup accountGroup = modelResult.getAccountGroup();
        assertEquals(accountGroup, new AccountGroup());

    }

    @Test
    public void checkAccountModelKeyIsNotNull() throws Exception{
        assertNotNull(new AddAccountGroupModel().getKey());
    }

    @Test
    public void testAddAccountPost() throws Exception{

        AddAccountGroupModel model = new AddAccountGroupModel();
        model.setAccountGroup(createTestAccountGroupDetails());

        mockMvc.perform(post("/add/account-group").sessionAttr(AddAccountGroupModel.KEY, model))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dashboard"))
                .andExpect(flash().attributeExists(FLASH_MESSAGE));
    }



}
