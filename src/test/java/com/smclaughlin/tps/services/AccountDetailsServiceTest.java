package com.smclaughlin.tps.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.IAccountDetailsService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


/**
 * Created by sineadmclaughlin on 29/11/2016.
 */
public class AccountDetailsServiceTest extends IntegrationTest{

    @Autowired
    IAccountDetailsService accountDetailsService;

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestGetAccountDetailsByUUID.xml")
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
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestGetListAccountDetails.xml")
    public void testGetListAccountDetails() throws Exception{

        AccountDetails ac = createTestAccountDetail();
        ac.setId(1L);
        ac.setAccountName("facebook");
        ac.setAccountWebsite("facebook.com");
        ac.setUsername("admin@test.com");
        ac.setPasswordHash("password");
        ac.setPasswordSalt("password");
        ac.setUuid("38a5639e-d041-4793-bfce-bccf81016e38");

        List<AccountDetails> serviceResult = accountDetailsService.returnListOfAccountDetails();
        assertThat(serviceResult.size(), equalTo(2));
        assertThat(serviceResult, hasItem(ac));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestSaveAccountDetails.xml")
    @ExpectedDatabase(assertionMode= DatabaseAssertionMode.NON_STRICT, value="/test_db/services/accountDetailsService/afterTestSaveAccountDetails.xml")
    public void testSaveAccountDetails() throws Exception{

        AccountDetails accountDetails = accountDetailsService.getAccountDetailsByUUID("38a5639e-d041-4793-bfce-bccf81016e38");
        accountDetails.setPasswordHash("password1");

        AccountDetails serviceResult = accountDetailsService.saveAccountDetails(accountDetails);
        assertThat(serviceResult, equalTo(accountDetails));

    }

    @Test
    @DatabaseSetup("/test_db/services/accountDetailsService/beforeTestCreateNewAccountDetails.xml")
    @ExpectedDatabase(assertionMode= DatabaseAssertionMode.NON_STRICT, value="/test_db/services/accountDetailsService/afterTestCreateNewAccountDetails.xml")
    public void testCreateNewAccountDetails() throws Exception{

        AccountDetails ac = new AccountDetails();
        ac.setId(2L);
        ac.setAccountName("facebook");
        ac.setAccountWebsite("facebook.com");
        ac.setUsername("admin@test.com");
        ac.setPasswordHash("password");
        ac.setPasswordSalt("EFyw4yY7mgAkt599");
        ac.setUuid("38a5639e-d041-4793-bfce-bccf81016e38");
        accountDetailsService.saveAccountDetails(ac);
    }


}
