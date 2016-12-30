package com.smclaughlin.tps.web.dashboard;

import com.smclaughlin.tps.entities.AccountDetails;
import com.smclaughlin.tps.service.IAccountDetailsService;
import com.smclaughlin.tps.service.security.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
@SessionAttributes(DashboardModel.KEY)
public class DashboardController {

    private static String DASHBOARD = "dashboard/dashboard";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @Autowired
    IPasswordService passwordService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        DashboardModel instanceModel = new DashboardModel();
        instanceModel.retrieveOrCreate(model);
    }


    @RequestMapping("/dashboard")
    public String getDashboard(@ModelAttribute(DashboardModel.KEY) DashboardModel model) {
        model.reset();
        model.setAccountDetailsList(accountDetailsService.returnListOfAccountDetails());

        return DASHBOARD;
    }

    @RequestMapping("/account/password/{uuid}")
    @ResponseBody
    public String displayAccountPassword(@PathVariable(name = "uuid") String uuid) {

        return passwordService.returnUnEncryptedPasswordFromAccountByUUID(uuid);
    }


}
