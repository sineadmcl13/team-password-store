package com.smclaughlin.tps.web.user;

import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.entities.User;
import com.smclaughlin.tps.web.accounts.AddAccountModel;
import org.junit.Test;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
public class AddUserTestController extends IntegrationTest{

    @Test
    public void testAddUserView() throws Exception{
        mockMvc.perform(get("/add/user"))
                .andExpect(view().name("user/addUser"));
    }

    @Test
    public void testAddUserModelReset() throws Exception{
        AddUserModel modelResult =
                (AddUserModel) mockMvc.perform(get("/add/user"))
                        .andReturn().getModelAndView().getModelMap().get(AddUserModel.KEY);

        User newUser = modelResult.getUser();
        assertEquals(newUser, new User());

    }

    @Test
    public void checkAccountModelKeyIsNotNull() throws Exception{
        assertNotNull(new AddUserModel().getKey());
    }

    @Test
    public void testAddAccountPost() throws Exception{

        AddUserModel model = new AddUserModel();
        model.setUser(createTestUser());

        mockMvc.perform(post("/add/user").sessionAttr(AddUserModel.KEY, model))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dashboard"))
                .andExpect(flash().attributeExists(FLASH_MESSAGE));
    }


    private User createTestUser(){
        User user = new User();
        user.setForename("Joe");
        user.setSurname("Bloggs");
        user.setDepartment("Finance");
        user.setEmail("test@companyname.com");

        return user;
    }


}
