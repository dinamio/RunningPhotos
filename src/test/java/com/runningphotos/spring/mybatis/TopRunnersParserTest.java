package com.runningphotos.spring.mybatis;

import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.service.TopRunnersParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import java.util.List;

/**
 * Created by ������� on 29.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TopRunnersParserTest {
    @Autowired
    TopRunnersParser topRunnersParser;
    @Autowired
    RunnerDao runnerDao;
    @Autowired
    ResultDao resultDao;

    @Test
    public  void parserTest(){
        topRunnersParser.parseAndInsert();
        List<Runner> runners = runnerDao.selectAll();
        List<Result> results = resultDao.selectAll();
        assertEquals("Vladimir", runners.get(4).getName());
        assertEquals("Semenuk",runners.get(4).getSurname());
        assertEquals(173,runners.size());
        assertEquals(172,results.size());
        assertEquals("00:31:37",results.get(0).getTime().getTimeToString());
        assertEquals("1097",results.get(0).getNumber());
        assertEquals("1",String.valueOf(results.get(0).getRunner().getId()));

    }
}
