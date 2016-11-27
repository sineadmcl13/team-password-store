package com.smclaughlin.tps.web;

import com.smclaughlin.tps.service.IAccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
public class DashboardController {

    private static String DASHBOARD = "home/dashboard";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @RequestMapping("/home")
    public String getDashboard(Model model) {

        model.addAttribute("account_details", accountDetailsService.getAccountDetailsById(1L));
        return DASHBOARD;
    }


}
