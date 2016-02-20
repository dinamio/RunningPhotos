package com.runningphotos.ui;

import com.runningphotos.bom.*;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.service.UsefulUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
