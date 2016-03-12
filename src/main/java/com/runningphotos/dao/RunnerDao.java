package com.runningphotos.dao;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ������� on 18.12.2015.
 */
public interface RunnerDao extends MyBatisDao<Runner> {

    Runner findRunner(Runner runner);

    List<Runner> selectRunnerBySurname(@Param("runnerCriteria")String runnerCriteria);
}
