package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 05.02.2016.
 */
@Controller
public class ResultsController {

    @RequestMapping(value = "/results")
    public ModelAndView getResults()
    {
        ModelAndView model = new ModelAndView("results");
        return model;
    }
}
