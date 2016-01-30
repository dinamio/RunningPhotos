package com.runningphotos.spring.mybatis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.service.TopRunnersParser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ������� on 29.12.2015.
 */
public class TopRunnersParserTest extends AbstractTest {
    @Autowired
    TopRunnersParser topRunnersParser;
    @Autowired
    RunnerDao runnerDao;
    @Autowired
    ResultDao resultDao;

    @Test
    @Ignore
    public  void parserTest(){
        String path = "http://toprunners.org/event-28-11-2015.html";
        String json;
        Gson gson = new Gson();
        json = topRunnersParser.parseToJson(path);
        List<Result> resultList = topRunnersParser.parse(path);
        Type type = new TypeToken<List<Result>>(){}.getType();
        List<Result> listFromJson= gson.fromJson(json,type);
        assertEquals(resultList.size(),listFromJson.size());
        assertEquals(resultList.get(0).getRunner().getName(),listFromJson.get(0).getRunner().getName());
        assertEquals(resultList.get(0).getRunner().getSurname(),listFromJson.get(0).getRunner().getSurname());
        assertEquals(resultList.get(0).getDistance(),listFromJson.get(0).getDistance());
        assertEquals(resultList.get(0).getNumber(),listFromJson.get(0).getNumber());
        assertEquals(resultList.get(0).getRace(),listFromJson.get(0).getRace());
        assertEquals(resultList.get(0).getTime(),listFromJson.get(0).getTime());
    }
}
