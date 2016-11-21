package com.smclaughlin.tps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
public class LoginController {

    private static String GREETING = "home/greeting";

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return GREETING;
    }

}
