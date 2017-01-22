package com.smclaughlin.tps.web.accounts;

import com.smclaughlin.tps.service.IAccountDetailsService;
import com.smclaughlin.tps.utils.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
@SessionAttributes(EditAccountModel.KEY)
public class EditAccountController {

    private static String EDIT_ACCOUNT = "accounts/editAccount";
    private static String REDIRECT_DASHBOARD = "redirect:/dashboard";

    @Autowired
    IAccountDetailsService accountDetailsService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        EditAccountModel instanceModel = new EditAccountModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/edit/account/{uuid}", method = RequestMethod.GET)
    public String getAddAccount(@ModelAttribute(EditAccountModel.KEY) EditAccountModel model, @PathVariable(name = "uuid") String uuid) {

        model.reset();
        model.setAccountDetails(accountDetailsService.getAccountDetailsByUUID(uuid));

        return EDIT_ACCOUNT;
    }

    @RequestMapping(value = "/edit/account/{uuid}", method = RequestMethod.POST)
    public String postAddAccount(@ModelAttribute(EditAccountModel.KEY) EditAccountModel model,  @PathVariable(name = "uuid") String uuid,
                                 final RedirectAttributes redirectAttributes) {

        accountDetailsService.saveAccountDetails(model.getAccountDetails());
        redirectAttributes.addFlashAttribute(FLASH_MESSAGE, new FlashMessage(SUCCESS, "flash.edit.account.success"));
        return REDIRECT_DASHBOARD;
    }

}
