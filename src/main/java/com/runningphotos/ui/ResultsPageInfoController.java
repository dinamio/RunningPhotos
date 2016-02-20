package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.Result;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.service.UsefulUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Bohdan on 09.02.2016.
 */
@Controller
public class ResultsPageInfoController {
    @Autowired
    ResultDao resultDao;

    @RequestMapping(value = "/results/resultspageinfo/{id}")
    public ModelAndView getResults( @PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("resultspageinfo");
        Race race = new Race();
        race.setId(id);
        List<Result> resultList = resultDao.getAllRaceResults(race);
         List<String> distances = UsefulUtils.getDistancesByResults(resultList);
        model.addObject("distances",distances);
        model.addObject("results", resultList);
        return model;
    }
}

