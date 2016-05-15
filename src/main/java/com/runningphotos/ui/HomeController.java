package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by eugenegodun on 1/14/16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView getHome()
    {
        ModelAndView model = new ModelAndView("index");
         return model;
    }

}
