package com.smclaughlin.tps.web.accounts;

import com.smclaughlin.tps.entities.AccountDetails;
import static com.smclaughlin.tps.utils.SystemEnums.*;

import com.smclaughlin.tps.service.IAccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
@SessionAttributes(AddAccountsModel.KEY)
public class AddAccountsController {

    private static String ADD_ACCOUNT = "accounts/addAccount";
    private static String REDIRECT_DASHBOARD = "redirect:/home";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        AddAccountsModel instanceModel = new AddAccountsModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.GET)
    public String getAddAccount(@ModelAttribute(AddAccountsModel.KEY) AddAccountsModel model) {
        model.reset();
        model.setAccountDetails(new AccountDetails());
        return ADD_ACCOUNT;
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.POST)
    public String postAddAccount(@ModelAttribute(AddAccountsModel.KEY) AddAccountsModel model,
                                 final RedirectAttributes redirectAttributes) {

        //Save new Account Detail
        accountDetailsService.createNewAccountDetails(model.getAccountDetails());
        redirectAttributes.addFlashAttribute(FLASH_MESSAGE.name(), "success");
        return REDIRECT_DASHBOARD;
    }

}