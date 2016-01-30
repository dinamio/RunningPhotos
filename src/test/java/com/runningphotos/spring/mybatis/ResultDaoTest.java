package com.runningphotos.spring.mybatis;

/**
 * Created by Oleg on 23.12.2015.
 */

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Distance;
import com.runningphotos.bom.Race;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import com.runningphotos.dao.DistanceDao;
import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class ResultDaoTest extends AbstractTest {

    private static Log log = LogFactory.getLog(ResultDaoTest.class);

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private ResultDao resultDao;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private DistanceDao distanceDao;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private RunnerDao runnerDao;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private RaceDao raceDao;


    @Test
    public void testRun(){
        testInsert();
        testGetAllRunnerResults();
        testGetAllRaceResults();
        testUpdate();
        testDelete();
    }

    private void testInsert() {
        log.info("testing insert Result()...");
        Result result = fillResult();
        resultDao.insert(result);
        List<Result> results = resultDao.selectAll();
        assertEquals(1,results.size());
        assertEquals(RESULT_TIME,results.get(0).getTime());
        assertEquals(RESULT_NUMBER,results.get(0).getNumber());
        assertEquals(result.getDistance().getId(),results.get(0).getDistance().getId());
        assertEquals(result.getRunner().getId(),results.get(0).getRunner().getId());
        assertEquals(result.getRace().getId(),results.get(0).getRace().getId());
        log.info(results);
    }

    private void testUpdate() {
        log.info("testing update Result()...");
        Result result = fillUpdateResult();
        List<Result> results = resultDao.selectAll();
        result.setId(results.get(0).getId());
        resultDao.update(result);
        results = resultDao.selectAll();
        assertEquals(RESULT_TIME_UPDATE,results.get(0).getTime());
        assertEquals(RESULT_NUMBER_UPDATE,results.get(0).getNumber());
        assertEquals(result.getDistance().getId(),results.get(0).getDistance().getId());
        assertEquals(result.getRunner().getId(),results.get(0).getRunner().getId());
        assertEquals(result.getRace().getId(),results.get(0).getRace().getId());
        log.info(results);
    }

    private void testDelete() {
        log.info("testing delete Result()...");
        List<Result> results = resultDao.selectAll();
        assertNotNull(results.get(0));
        resultDao.delete(results.get(0));
        results = resultDao.selectAll();
        assertEquals(0,results.size());
    }

    private void testGetAllRunnerResults(){
        log.info("testing getAllRunnerResults()...");
        Runner runner = runnerDao.selectAll().get(0);
        List<Result> results = resultDao.getAllRunnerResults(runner);
        assertEquals(1,results.size());
        assertEquals(runner.getId(),results.get(0).getRunner().getId());
        log.info(results);
    }

    private void testGetAllRaceResults(){
        log.info("testing getAllRaceResults()...");
        Race race = raceDao.selectAll().get(0);
        List<Result> results = resultDao.getAllRaceResults(race);
        assertEquals(1,results.size());
        assertEquals(race.getId(),results.get(0).getRace().getId());
        log.info(results);
    }

    private Result fillUpdateResult(){
        Distance distance = new Distance();
        distance.setId(2);
        Result result = new Result();
        result.setTime(RESULT_TIME_UPDATE);
        result.setNumber(RESULT_NUMBER_UPDATE);
        result.setDistance(distanceDao.selectAll().get(1));
        result.setRunner(runnerDao.selectAll().get(0));
        result.setRace(raceDao.selectAll().get(1));
        return result;
    }

    private Result fillResult(){
        Result result = new Result();
        result.setTime(RESULT_TIME);
        result.setNumber(RESULT_NUMBER);
        result.setDistance(distanceDao.selectAll().get(0));
        result.setRunner(runnerDao.selectAll().get(0));
        result.setRace(raceDao.selectAll().get(0));
        return result;
    }


}
