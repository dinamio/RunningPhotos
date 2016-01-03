package com.runningphotos.spring.mybatis;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
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
 * Created by Overdark on 28.12.2015.
 * Updatet by Overdark on 03.01.2016
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")


    public class RaceDaoTest extends TestData {

    private static Log log = LogFactory.getLog(RaceDaoTest.class);

    @Autowired
    private RaceDao raceDao;

    @Test
    public void testInsert() {
        log.info("testing insert Race()...");
        clearRaceTable();
        Race race = new Race();
        race = fillRace();
        raceDao.insert(race);
        List<Race> races = raceDao.selectAll();
        System.out.println(race + "first test");
        assertEquals(1, races.size());
        race = races.get(0);
        assertEquals(dateFormat.format(RACE_DATE),dateFormat.format(race.getRaceDate()));
        assertEquals(RACE_CITY, race.getCity());
        assertEquals(RACE_NAME, race.getName());
        log.info(races);
    }

    @Test
    public void testUpdate() {
        log.info("testing update Race()...");
        clearRaceTable();
        Race race = new Race();
        race = fillRace();
        raceDao.insert(race);
        List<Race> races = raceDao.selectAll();


        race = fillUpdateRace();
        race.setId(races.get(0).getId());

        raceDao.update(race);
        races = raceDao.selectAll();
        System.out.println(races.get(0) + " second Test");
        assertEquals(dateFormat.format(RACE_DATE_UPDATE),dateFormat.format(race.getRaceDate()));
        assertEquals(RACE_CITY_UPDATE, races.get(0).getCity());
        assertEquals(RACE_NAME_UPDATE, races.get(0).getName());
        log.info(races);
    }

    @Test
    public void deleteTest() {
        log.info("testing delete Race()...");
        clearRaceTable();
        Race race = new Race();
        race = fillRace();
        raceDao.insert(race);
        List<Race> races = raceDao.selectAll();

        assertNotNull(races.get(0));

        raceDao.delete(races.get(0));
        races = raceDao.selectAll();
        assertEquals(0, races.size());
    }

    private Race fillRace() {
        Race race = new Race();
        race.setRaceDate(RACE_DATE);
        race.setCity(RACE_CITY);
        race.setName(RACE_NAME);
        return race;
    }

    private Race fillUpdateRace() {
        Race race = new Race();
        race.setRaceDate(RACE_DATE_UPDATE);
        race.setCity(RACE_CITY_UPDATE);
        race.setName(RACE_NAME_UPDATE);
        return race;
    }

    private void clearRaceTable() {
        List<Race> result = raceDao.selectAll();
        for (int i = 0; i < result.size(); i++)
            raceDao.delete(result.get(i));
    }


}