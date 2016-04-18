package com.runningphotos.ui;

import com.runningphotos.bom.*;
import com.runningphotos.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Tensa on 09.02.2016.
 */
@Controller
@RequestMapping(value = "/runner")
public class RunnerController {

    @Autowired
    private ResultDao resultDao;
    @Autowired
    private RunnerDao runnerDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RaceDao raceDao;
    @Autowired
    private DistanceDao distanceDao;

    @RequestMapping(value = "/myRaces", method = RequestMethod.GET)
    public ModelAndView openMyRaces()
    {
        String allSpeed;
        double tmpallSpeed = 0;
        double allLength = 0;
        int allRaces = 0;

         ModelAndView model = new ModelAndView("/runner/myRaces");
         SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String userName = authentication.getName();
         User user = userDao.selectByUsername(userName);
         Runner runner = runnerDao.selectById(user.getRunner().getId());
         List<Result> resultList = resultDao.getAllRunnerResults(runner);
         List<String> speeds = new LinkedList<String>();
         for (int i =0; i < resultList.size();i++) {
                resultList.get(i).setRace(raceDao.selectById(resultList.get(i).getRace().getId()));
                resultList.get(i).setDistance(distanceDao.selectById(resultList.get(i).getDistance().getId()));

                double time = ((resultList.get(i).getTime().getHours() * 60 * 60) + (resultList.get(i).getTime().getMinutes()*60)+ (resultList.get(i).getTime().getSeconds()));
                double length = (resultList.get(i).getDistance().getLength());
                double tmpSpeed =(Math.rint(100.0 * (time / length)) / 100.0);
                speeds.add(sdf.format(new Date((long) tmpSpeed*1000)));
                allLength = allLength + resultList.get(i).getDistance().getLength();
                tmpallSpeed = tmpallSpeed + tmpSpeed;
         }
         allSpeed = sdf.format(new Date((long)((tmpallSpeed/resultList.size())*1000)));
         allRaces = resultList.size();

         model.addObject("allRaces",allRaces);
         model.addObject("allSpeed", allSpeed);
         model.addObject("allLength", allLength);
         model.addObject("speeds", speeds);
         model.addObject("runner", runner);
         model.addObject("resultList", resultList);

         return model;
    }
}