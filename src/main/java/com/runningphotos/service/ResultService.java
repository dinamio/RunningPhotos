package com.runningphotos.service;

import com.runningphotos.bom.Result;
import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eugenegodun on 2/23/16.
 */
@Service
public class ResultService {

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private RunnerService runnerService;

    public void insertResults(List<Result> results) {
        for(Result result : results)  {
            result.setRunner(runnerService.insertRunnerIfNotExists(result.getRunner()));
            result.setDistance(distanceService.insertDistanceIfNotExists(result.getDistance()));
            resultDao.insert(result);
        }

    }
}
