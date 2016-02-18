package com.runningphotos.ui;

import com.runningphotos.bom.Distance;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import com.runningphotos.bom.Time;
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

    @Autowired
    RunnerDao runnerDao;


    @RequestMapping(value = "/")
    public ModelAndView getHome()
    {
        ModelAndView model = new ModelAndView("index");
        List<Result> results = createMockResults();
        List<String> distances = UsefulUtils.getDistancesByResults(results);
        model.addObject("results",results);
        model.addObject("distances",distances);
        return model;
    }

    private List<Result> createMockResults() {
        List<Runner> runners = runnerDao.selectAll();
        List<Result> results = new ArrayList<Result>();
        Distance km42= new Distance();
        km42.setName("Марафон");
        Distance km21= new Distance();
        km21.setName("Полумарафон");
        Result res = new Result();
        res.setNumber("1");
        res.setDistance(km42);
        res.setRunner(runners.get(0));
        res.setTime(new Time(1,1,1));
        results.add(res);

        res = new Result();
        res.setNumber("2");
        res.setDistance(km42);
        res.setRunner(runners.get(1));
        res.setTime(new Time(2,2,2));
        results.add(res);

        res = new Result();
        res.setNumber("3");
        res.setDistance(km21);
        res.setRunner(runners.get(2));
        res.setTime(new Time(3,3,3));
        results.add(res);

        res = new Result();
        res.setNumber("4");
        res.setDistance(km21);
        res.setRunner(runners.get(3));
        res.setTime(new Time(4,4,4));
        results.add(res);
        return results;
    }
}
