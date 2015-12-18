package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.bom.Role;
import com.runningphotos.bom.Runner;
import com.runningphotos.bom.User;
import com.runningphotos.dao.RoleDao;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.dao.UserDao;
import com.runningphotos.testdata.TestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")


//
public class RunnerDaoTest extends TestData {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RunnerDao runnerDao;

    @Autowired
    private RoleDao roleDao;


    @Test

    public void testInsert(){
        log.info("testing insert Runner()...");
        clearRunnerTable();
        Runner runner = new Runner();
        runner = fillRunner();
        runnerDao.insert(runner);
        List<Runner> runners = runnerDao.selectAll();
        assertEquals(1, runners.size());
        assertEquals(RUNNER_NAME, runners.get(0).getName());
        assertEquals(RUNNER_SURNAME, runners.get(0).getSurname());
        assertEquals(runner.getUser().getId(),runners.get(0).getUser().getId());
        log.info(runner);
    }

   @Test
    public void testUpdate(){
        log.info("testing update Runner()...");
        clearRunnerTable();
        Runner runner = new Runner();
        runner = fillRunner();
        runnerDao.insert(runner);
        List<Runner> runners = runnerDao.selectAll();
        runner = fillUpdatedRunner();
        runner.setId(runners.get(0).getId());
        runnerDao.update(runner);
        runners = runnerDao.selectAll();
        assertEquals(RUNNER_NAME_UPDATE, runners.get(0).getName());
        assertEquals(RUNNER_SURNAME_UPDATE, runners.get(0).getSurname());
        assertEquals(runner.getUser().getId(), runners.get(0).getUser().getId());
        log.info(runners);
    }
    @Test
    public void testDelete(){
        log.info("testing delete Runner()...");
        clearRunnerTable();
        Runner runner = new Runner();
        runner = fillRunner();
        runnerDao.insert(runner);
        List<Runner> runners = runnerDao.selectAll();
        assertNotNull(runners.get(0));
        runnerDao.delete(runners.get(0));
        runners = runnerDao.selectAll();
        //assertEquals(0,runners.size());
    }
    private Runner fillUpdatedRunner(){
//
        User user = new User();

        Runner runner = new Runner();

        user.setName(USERNAME_UPDATE);
        user.setSurname(USER_SURNAME_UPDATE);
        user.setLogin(USER_LOGIN_UPDATE);
        user.setMail(USER_MAIL_UPDATE);
        user.setBirthDate(USER_BIRTHDAY_UPDATE);
        user.setCity(USER_CITY_UPDATE);
        userDao.update(user);
        List<User> users = userDao.selectAll();
        user = users.get(0);
        runner.setName(RUNNER_NAME_UPDATE);
        runner.setSurname(RUNNER_SURNAME_UPDATE);
        runner.setUser(user);
        return runner;
    }
    private Runner fillRunner(){

        User user = new User();

        Runner runner = new Runner();
        List<User> users = userDao.selectAll();
        user=users.get(0);
        runner.setName(RUNNER_NAME);
        runner.setSurname(RUNNER_SURNAME);
        runner.setUser(user);
        return runner;
    }

    private void clearRunnerTable(){
        List<Runner > result =  runnerDao.selectAll();
        for(int i=0;i<result.size();i++)
            runnerDao.delete(result.get(i));
    }
}
