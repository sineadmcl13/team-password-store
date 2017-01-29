package com.smclaughlin.tps.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.User;
import com.smclaughlin.tps.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;




/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
public class UserServiceTest extends IntegrationTest{

    @Autowired
    IUserService userService;

    @Test
    @DatabaseSetup("/test_db/services/userService/beforeTestCreateNewUser.xml")
    @ExpectedDatabase(assertionMode= DatabaseAssertionMode.NON_STRICT, value="/test_db/services/userService/afterTestCreateNewUser.xml")
    public void testCreateNewUser() throws Exception{

        User user = new User();
        user.setForename("Joe");
        user.setSurname("Bloggs");
        user.setDepartment("Finance");
        user.setEmail("test@companyname.com");

        userService.createNewUser(user);
    }


}
