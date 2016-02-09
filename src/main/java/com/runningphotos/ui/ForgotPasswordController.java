package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 06.02.2016.
 */
@Controller
public class ForgotPasswordController {
    @RequestMapping(value = "/forgotPassword")
    public ModelAndView getForgotPassword()
    {
        ModelAndView model = new ModelAndView("forgotPassword");
        return model;
    }
}
