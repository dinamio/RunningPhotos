package com.runningphotos.dao;

import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;

/**
 * Created by ������� on 18.12.2015.
 */
public interface RunnerDao extends MyBatisDao<Runner> {
    Runner findRunner(Runner runner);
}
