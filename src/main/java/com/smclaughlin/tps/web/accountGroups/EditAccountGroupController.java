package com.smclaughlin.tps.web.accountGroups;

import com.smclaughlin.tps.service.IAccountGroupService;
import com.smclaughlin.tps.utils.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

/**
 * Created by sineadmclaughlin on 23/01/2017.
 */
@Controller
@SessionAttributes(EditAccountGroupModel.KEY)
public class EditAccountGroupController {

    private static String ADD_GROUP = "group/editGroup";
    private static String REDIRECT_DASHBOARD = "redirect:/dashboard";

    @Autowired
    IAccountGroupService groupService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        EditAccountGroupModel instanceModel = new EditAccountGroupModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/edit/account-group/{uuid}", method = RequestMethod.GET)
    public String getAddGroup(@ModelAttribute(EditAccountGroupModel.KEY) EditAccountGroupModel model,
                              @PathVariable(name = "uuid") String uuid, BindingResult result,
                              RedirectAttributes redirectAttributes) {
        model.reset();
        model.setAccountGroup(groupService.getAccountDetailsByUUID(uuid));
        return ADD_GROUP;
    }

    @RequestMapping(value = "/edit/account-group/{uuid}", method = RequestMethod.POST)
    public String postAddGroup(@ModelAttribute(EditAccountGroupModel.KEY) EditAccountGroupModel model,
                               @PathVariable(name = "uuid") String uuid, RedirectAttributes redirectAttributes) {

        groupService.saveAccountGroup(model.getAccountGroup());
        redirectAttributes.addFlashAttribute(FLASH_MESSAGE, new FlashMessage(SUCCESS, "flash.edit.account.group.success"));
        return REDIRECT_DASHBOARD;
    }

}
