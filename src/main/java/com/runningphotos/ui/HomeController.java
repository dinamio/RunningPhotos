package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eugenegodun on 1/14/16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String getHome()
    {
        return "index";
    }
}
