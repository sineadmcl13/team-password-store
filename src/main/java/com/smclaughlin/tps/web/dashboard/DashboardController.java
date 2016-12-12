package com.smclaughlin.tps.web.dashboard;

import com.smclaughlin.tps.service.IAccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
@SessionAttributes(DashboardModel.KEY)
public class DashboardController {

    private static String DASHBOARD = "home/dashboard";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        DashboardModel instanceModel = new DashboardModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping("/home")
    public String getDashboard(@ModelAttribute(DashboardModel.KEY) DashboardModel model) {

        model.reset();
        return DASHBOARD;
    }


}
