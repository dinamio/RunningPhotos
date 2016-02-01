package com.runningphotos.dao;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;

import java.util.List;

/**
 * Created by Oleg on 22.12.2015.
 */
public interface ResultDao extends MyBatisDao<Result> {

    List<Result> getAllRunnerResults(Runner runner);

    List<Result> getAllRaceResults(Race race);

    Result selectResultByRaseAndNamber(Race race, String number);
}
