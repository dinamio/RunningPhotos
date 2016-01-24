package com.runningphotos.ui;

import com.runningphotos.bom.Runner;
import com.runningphotos.dao.RunnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by eugenegodun on 1/14/16.
 */
@Controller
public class HomeController {

    @Autowired
    RunnerDao runnerDao;


    @RequestMapping(value = "/")
    public ModelAndView getHome()
    {
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}
