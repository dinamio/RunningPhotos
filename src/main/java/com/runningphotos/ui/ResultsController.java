package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class ResultsController {
    @Autowired
    RaceDao raceDao;

    @Value(value = "${path.to.file}")
    private String path;

    @RequestMapping (value = "/results")
    public ModelAndView getRaces(){
        ModelAndView mav = new ModelAndView("ResultPage");
        List<Race> raceList = raceDao.selectAll();
        mav.addObject("races", raceList);
        mav.addObject("path", path);
        return mav;
    }
}

