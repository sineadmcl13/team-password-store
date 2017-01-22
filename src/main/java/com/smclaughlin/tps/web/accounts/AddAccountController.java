package com.smclaughlin.tps.web.accounts;

import com.smclaughlin.tps.entities.AccountDetails;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

import com.smclaughlin.tps.service.IAccountDetailsService;
import com.smclaughlin.tps.utils.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
@SessionAttributes(AddAccountModel.KEY)
public class AddAccountController {

    private static String ADD_ACCOUNT = "accounts/addAccount";
    private static String REDIRECT_DASHBOARD = "redirect:/dashboard";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        AddAccountModel instanceModel = new AddAccountModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.GET)
    public String getAddAccount(@ModelAttribute(AddAccountModel.KEY) AddAccountModel model,
                                BindingResult result, RedirectAttributes redirectAttributes) {
        model.reset();
        model.setAccountDetails(new AccountDetails());
        return ADD_ACCOUNT;
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.POST)
    public String postAddAccount(@ModelAttribute(AddAccountModel.KEY) AddAccountModel model,
                                 RedirectAttributes redirectAttributes) {

        accountDetailsService.createNewAccountDetails(model.getAccountDetails());
        redirectAttributes.addFlashAttribute(FLASH_MESSAGE, new FlashMessage(SUCCESS, "flash.add.account.success"));
        return REDIRECT_DASHBOARD;
    }

}
