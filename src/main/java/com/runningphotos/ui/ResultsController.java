package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class ResultsController {
    @Autowired
    RaceDao raceDao;

    @RequestMapping (value = "/results")
    public ModelAndView getRaces(){
        ModelAndView mav = new ModelAndView("ResultPage");
        List<Race> raceList = raceDao.selectRacesWithResult();
        mav.addObject("races", raceList);
        return mav;
    }
}

