package com.runningphotos.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by eugenegodun on 1/19/16.
 */
@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Locale locale) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", messageSource.getMessage("login.invalid",null,locale));
        }
        if (logout != null) {
            model.addObject("msg",  messageSource.getMessage("login.out",null,locale));
        }
        model.setViewName("login");

        return model;

    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        for (Cookie cookie : request.getCookies())
        {
            if (cookie.getName().equals("remember-me")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
