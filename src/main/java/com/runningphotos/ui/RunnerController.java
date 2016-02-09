package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 09.02.2016.
 */
@Controller
@RequestMapping(value = "/runner")
public class RunnerController {

    public ModelAndView openMyRaces()
    {
        ModelAndView model = new ModelAndView("/runner/myRaces");
        return model;
    }
}