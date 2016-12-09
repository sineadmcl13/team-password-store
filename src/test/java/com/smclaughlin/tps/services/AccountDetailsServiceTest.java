package com.smclaughlin.tps.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.IAccountDetailsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by sineadmclaughlin on 29/11/2016.
 */
public class AccountDetailsServiceTest extends IntegrationTest{

    @Autowired
    IAccountDetailsService accountDetailsService;

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestGetAccountDetailsById.xml")
    @DatabaseTearDown
    public void testGetAccountDetailsById() throws Exception{

        AccountDetails accountDetails = new AccountDetails(1L, "testAccount", "google.com", "admin@test.com", "password", "password");
        AccountDetails serviceResult = accountDetailsService.getAccountDetailsById(1L);
        assertThat(serviceResult, equalTo(accountDetails));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestSaveAccountDetails.xml")
    @ExpectedDatabase("/test_db/services/accountDetailsService/afterTestSaveAccountDetails.xml")
    @DatabaseTearDown
    public void testSaveAccountDetails() throws Exception{

        AccountDetails accountDetails = new AccountDetails(1L, "testAccount", "google.com", "admin@test.com", "password2", "password");

        AccountDetails serviceResult = accountDetailsService.saveAccountDetails(accountDetails);
        assertThat(serviceResult, equalTo(accountDetails));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestCreateNewAccountDetails.xml")
    @ExpectedDatabase("/test_db/services/accountDetailsService/afterTestCreateNewAccountDetails.xml")
    @DatabaseTearDown
    public void testCreateNewAccountDetails() throws Exception{

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountName("testAccount");
        accountDetails.setAccountWebsite("test.com");
        accountDetails.setUsername("testUser");
        accountDetails.setPasswordSalt("passwordSalt");
        accountDetails.setPasswordHash("passwordHash");

        accountDetailsService.createNewAccountDetails(accountDetails);
    }


}
