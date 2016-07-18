package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
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
    private RaceDao raceDao;

    @RequestMapping(value = "/")
    public ModelAndView getHome()
    {
        ModelAndView model = new ModelAndView("index");
        List<Race> races = raceDao.selectAll();
        model.addObject("races",races);
        return model;
    }

}
