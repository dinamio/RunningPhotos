package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by eugenegodun on 1/19/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String getLoginPage()
    {
       return "login";
    }
}
