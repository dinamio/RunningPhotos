package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.bom.Runner;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.dao.UserDao;
import com.runningphotos.testdata.TestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class RunnerDaoTest extends TestData {

    private static Log log = LogFactory.getLog(RunnerDaoTest.class);

    @Autowired
    private RunnerDao runnerDao;

    @Autowired
    private UserDao userDao;


    @Test
    public void testRun(){
        testInsert();
        testUpdate();
        testDelete();
    }


    private void testInsert(){
        log.info("testing insert Runner()...");
        Runner runner = fillRunner();
        runnerDao.insert(runner);
        List<Runner> runners = runnerDao.selectAll();
        assertEquals(2, runners.size());
        assertEquals(RUNNER_NAME, runners.get(1).getName());
        assertEquals(RUNNER_SURNAME, runners.get(1).getSurname());
        assertEquals(RUNNER_SEX, runners.get(1).getSex());
        assertEquals(runner.getUser().getId(),runners.get(1).getUser().getId());
        log.info(runner);
    }

    private void testUpdate(){
        log.info("testing update Runner()...");
        List<Runner> runners = runnerDao.selectAll();
        Runner runner = fillUpdatedRunner();
        runner.setId(runners.get(1).getId());
        runnerDao.update(runner);
        runners = runnerDao.selectAll();
        assertEquals(RUNNER_NAME_UPDATE, runners.get(1).getName());
        assertEquals(RUNNER_SURNAME_UPDATE, runners.get(1).getSurname());
        assertEquals(RUNNER_SEX_UPDATE, runners.get(1).getSex());
        assertEquals(runner.getUser().getId(), runners.get(1).getUser().getId());
        log.info(runners);
    }

    private void testDelete(){
        log.info("testing delete Runner()...");
        List<Runner> runners = runnerDao.selectAll();
        assertNotNull(runners.get(1));
        runnerDao.delete(runners.get(1));
        runners = runnerDao.selectAll();
        assertEquals(1,runners.size());
    }
    private Runner fillUpdatedRunner(){
        Runner runner = new Runner();
        runner.setName(RUNNER_NAME_UPDATE);
        runner.setSurname(RUNNER_SURNAME_UPDATE);
        runner.setSex(RUNNER_SEX_UPDATE);
        runner.setUser(userDao.selectAll().get(1));
        return runner;
    }
    private Runner fillRunner(){
        Runner runner = new Runner();
        runner.setName(RUNNER_NAME);
        runner.setSurname(RUNNER_SURNAME);
        runner.setSex(RUNNER_SEX);
        runner.setUser(userDao.selectAll().get(0));
        return runner;
    }

//    private void clearRunnerTable(){
//        List<Runner > result =  runnerDao.selectAll();
//        for(int i=0;i<result.size();i++)
//            runnerDao.delete(result.get(i));
//    }
}
