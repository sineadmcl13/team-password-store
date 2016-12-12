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
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestGetAccountDetailsByUUID.xml")
    @DatabaseTearDown
    public void testGetAccountDetailsByUUID() throws Exception{

        AccountDetails ac = createTestAccountDetail();
        ac.setId(1L);
        ac.setAccountName("facebook");
        ac.setAccountWebsite("facebook.com");
        ac.setUsername("admin@test.com");
        ac.setPasswordHash("password");
        ac.setPasswordSalt("password");
        ac.setUuid("38a5639e-d041-4793-bfce-bccf81016e38");

        AccountDetails serviceResult = accountDetailsService.getAccountDetailsByUUID("38a5639e-d041-4793-bfce-bccf81016e38");
        assertThat(serviceResult, equalTo(ac));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestSaveAccountDetails.xml")
    @ExpectedDatabase("/test_db/services/accountDetailsService/afterTestSaveAccountDetails.xml")
    @DatabaseTearDown
    public void testSaveAccountDetails() throws Exception{

        AccountDetails accountDetails = accountDetailsService.getAccountDetailsByUUID("38a5639e-d041-4793-bfce-bccf81016e38");
        accountDetails.setPasswordHash("password1");

        AccountDetails serviceResult = accountDetailsService.saveAccountDetails(accountDetails);
        assertThat(serviceResult, equalTo(accountDetails));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestCreateNewAccountDetails.xml")
    @ExpectedDatabase("/test_db/services/accountDetailsService/afterTestCreateNewAccountDetails.xml")
    @DatabaseTearDown
    public void testCreateNewAccountDetails() throws Exception{

        AccountDetails accountDetails = createTestAccountDetail();
        accountDetailsService.createNewAccountDetails(accountDetails);
    }


}
