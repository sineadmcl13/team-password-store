package com.smclaughlin.tps.web.user;

import com.smclaughlin.tps.service.IUserService;
import com.smclaughlin.tps.service.security.IPasswordService;
import com.smclaughlin.tps.utils.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.smclaughlin.tps.utils.FlashMessage.FLASH_MESSAGE;
import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
@Controller
@SessionAttributes(AddUserModel.KEY)
public class AddUserController {

    private static String ADD_USER = "user/addUser";

    private static String REDIRECT_DASHBOARD= "redirect:/dashboard";

    @Autowired
    IPasswordService passwordService;

    @Autowired
    IUserService userService;

    @ModelAttribute
    public void formBacking(ModelMap model) {
        AddUserModel instanceModel = new AddUserModel();
        instanceModel.retrieveOrCreate(model);
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String addUserGet(@ModelAttribute(AddUserModel.KEY) AddUserModel model) {
        model.reset();

        return ADD_USER;
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute(AddUserModel.KEY) AddUserModel model,
                              RedirectAttributes redirectAttributes) {

        String tempPassword = passwordService.generateTempPassword();
        model.getUser().setPasswordHash(tempPassword);
        userService.createNewUser(model.getUser());

        redirectAttributes.addFlashAttribute(FLASH_MESSAGE, new FlashMessage(SUCCESS, "flash.add.user.success"));
        return REDIRECT_DASHBOARD;
    }
}
