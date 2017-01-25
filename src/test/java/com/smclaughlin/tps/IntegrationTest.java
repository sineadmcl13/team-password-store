package com.smclaughlin.tps;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.entities.AccountGroup;
import com.smclaughlin.tps.utils.CipherGenerator;
import com.smclaughlin.tps.utils.SaltGenerator;
import com.smclaughlin.tps.utils.UUIDGenerator;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.ITableFilter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.mockito.Matchers.any;


/**
 * Created by sineadmclaughlin on 22/11/2016.
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(PowerMockRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class,
        WithSecurityContextTestExecutionListener.class})
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore({"javax.management.*", "javax.crypto.*"})
@PrepareForTest({UUIDGenerator.class, SaltGenerator.class, CipherGenerator.class})
public abstract class IntegrationTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;
    protected String ABSOLUTE_PATH = "http://localhost/";

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Before
    public void setUpMocks(){
        PowerMockito.mockStatic(UUIDGenerator.class);
        PowerMockito.mockStatic(SaltGenerator.class);
        PowerMockito.mockStatic(CipherGenerator.class);

        PowerMockito.when(UUIDGenerator.randomUUID()).thenReturn(UUID.fromString("38a5639e-d041-4793-bfce-bccf81016e38"));
        PowerMockito.when(SaltGenerator.generateSalt()).thenReturn("EFyw4yY7mgAkt599");
        PowerMockito.when(CipherGenerator.encrypt(any(), any())).thenReturn("3Y6QyLpob7LeZtwoxkhQzOP");

    }

    protected AccountDetails createTestAccountDetail(){
        AccountDetails ac = new AccountDetails();
        ac.setId(1L);
        ac.setAccountName("facebook");
        ac.setAccountWebsite("facebook.com");
        ac.setUsername("admin@test.com");
        ac.setPasswordHash("password");
        ac.setPasswordSalt("EFyw4yY7mgAkt599");
        ac.setUuid("38a5639e-d041-4793-bfce-bccf81016e38");
        return ac;
    }

    protected AccountGroup createTestAccountGroupDetails(){
        AccountGroup accountGroup = new AccountGroup();
        accountGroup.setId(1L);
        accountGroup.setUuid("38a5639e-d041-4793-bfce-bccf81016e38");
        accountGroup.setGroupName("TestGroupName");
        return accountGroup;
    }

}
