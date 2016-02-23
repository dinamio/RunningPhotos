package com.runningphotos.service;

import com.runningphotos.bom.Runner;
import com.runningphotos.dao.RunnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eugenegodun on 2/23/16.
 */
@Service
public class RunnerService {

    @Autowired
    private RunnerDao runnerDao;


    public Runner insertRunnerIfNotExists(Runner runner) {
        Runner fromDatabase = runnerDao.findRunner(runner);
        if (fromDatabase == null) {
            runnerDao.insert(runner);
            return runner;
        }
        return fromDatabase;
    }
}
