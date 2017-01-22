package com.smclaughlin.tps.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.smclaughlin.tps.IntegrationTest;
import com.smclaughlin.tps.entities.AccountGroup;
import com.smclaughlin.tps.service.IAccountGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
public class AccountGroupServiceTest extends IntegrationTest{

    @Autowired
    IAccountGroupService accountGroupService;


    @Test
    @DatabaseSetup("/test_db/services/accountGroupService/beforeTestCreateNewAccountGroup.xml")
    @ExpectedDatabase(assertionMode= DatabaseAssertionMode.NON_STRICT, value="/test_db/services/accountGroupService/afterTestCreateNewAccountGroup.xml")
    @DatabaseTearDown
    public void testCreateNewAccountDetails() throws Exception{

        AccountGroup accountGroup = createTestAccountGroupDetails();
        accountGroupService.createNewAccountGroup(accountGroup);
    }


    @Test
    @DatabaseSetup("/test_db/services/accountGroupService/beforeTestSaveAccountGroup.xml")
    @ExpectedDatabase(assertionMode= DatabaseAssertionMode.NON_STRICT, value="/test_db/services/accountGroupService/afterTestSaveAccountGroup.xml")
    @DatabaseTearDown
    public void testSaveAccountGroup() throws Exception{

        AccountGroup accountGroup = accountGroupService.getAccountDetailsByUUID("38a5639e-d041-4793-bfce-bccf81016e49");
        accountGroup.setGroupName("TestGroup2");

        AccountGroup serviceResult = accountGroupService.saveAccountGroup(accountGroup);
        assertThat(serviceResult, equalTo(accountGroup));

    }
}
