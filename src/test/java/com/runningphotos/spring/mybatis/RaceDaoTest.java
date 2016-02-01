package com.runningphotos.spring.mybatis;

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Overdark on 28.12.2015.
 * Updatet by Overdark on 03.01.2016
 */


public class RaceDaoTest extends AbstractTest {

    private static Log log = LogFactory.getLog(RaceDaoTest.class);

    @Autowired
    private RaceDao raceDao;

    @Test
    public void testRun(){
        testInsert();
        testUpdate();
        deleteTest();
    }

    private void testInsert() {
        log.info("testing insert Race()...");
        Race race = fillRace();
        raceDao.insert(race);
        List<Race> races = raceDao.selectAll();
        System.out.println(race + "first test");
        assertEquals(3, races.size());
        race = races.get(2);
        assertEquals(dateFormat.format(RACE_DATE),dateFormat.format(race.getRaceDate()));
        assertEquals(RACE_CITY, race.getCity());
        assertEquals(RACE_NAME, race.getName());
        log.info(races);
    }

    private void testUpdate() {
        log.info("testing update Race()...");
        List<Race> races = raceDao.selectAll();
        Race race = fillUpdateRace();
        race.setId(races.get(2).getId());
        raceDao.update(race);
        races = raceDao.selectAll();
        System.out.println(races.get(2) + " second Test");
        assertEquals(dateFormat.format(RACE_DATE_UPDATE),dateFormat.format(races.get(2).getRaceDate()));
        assertEquals(RACE_CITY_UPDATE, races.get(2).getCity());
        assertEquals(RACE_NAME_UPDATE, races.get(2).getName());
        log.info(races);
    }

    private void deleteTest() {
        log.info("testing delete Race()...");
        List<Race> races = raceDao.selectAll();
        assertNotNull(races.get(2));
        raceDao.delete(races.get(2));
        races = raceDao.selectAll();
        assertEquals(2, races.size());
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


}