package com.smclaughlin.tps.web.accountGroups;

import com.smclaughlin.tps.service.IAccountGroupService;
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

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Controller
@SessionAttributes(AddAccountGroupModel.KEY)
public class AddAccountGroupController {

    private static String ADD_GROUP = "group/addGroup";
    private static String REDIRECT_DASHBOARD = "redirect:/dashboard";

    @Autowired
    IAccountGroupService groupService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        AddAccountGroupModel instanceModel = new AddAccountGroupModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/add/account-group", method = RequestMethod.GET)
    public String getAddGroup(@ModelAttribute(AddAccountGroupModel.KEY) AddAccountGroupModel model,
                                BindingResult result, RedirectAttributes redirectAttributes) {
        model.reset();
        return ADD_GROUP;
    }

    @RequestMapping(value = "/add/account-group", method = RequestMethod.POST)
    public String postAddGroup(@ModelAttribute(AddAccountGroupModel.KEY) AddAccountGroupModel model,
                                 RedirectAttributes redirectAttributes) {

        groupService.saveAccountGroup(model.getAccountGroup());
        redirectAttributes.addFlashAttribute(FLASH_MESSAGE, new FlashMessage(SUCCESS, "flash.add.account.group.success"));
        return REDIRECT_DASHBOARD;
    }

}
