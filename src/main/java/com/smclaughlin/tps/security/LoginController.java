package com.smclaughlin.tps.security;

import com.smclaughlin.tps.utils.FlashMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.smclaughlin.tps.utils.FlashMessage.MessageType.SUCCESS;

/**
 * Created by sineadmclaughlin on 21/11/2016.
 */
@Controller
public class LoginController {

    private final String LOGIN_PAGE = "login";
    private final String REDIRECT_DASHBOARD = "redirect:/dashboard";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String onGetLogin() {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String onRoot() {
        return REDIRECT_DASHBOARD;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String onLogout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, auth);

        return "redirect:/login?logout";
    }

}
