package com.runningphotos.spring.mybatis;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.RacePhoto;

import com.runningphotos.bom.User;
import com.runningphotos.dao.RacePhotoDao;


import com.runningphotos.dao.UserDao;
import com.runningphotos.testdata.TestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zOpa on 22.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class RacePhotoTest extends TestData {

    private static Log log = LogFactory.getLog(RacePhotoTest.class);

    @Autowired
    private RacePhotoDao racePhotoDao;
    @Autowired
    private UserDao userDao;
    //  @Autowired
   // private RaceDao raceDao;

    @Test
    public void testInsert(){
        log.info("testing insert RacePhoto()...");
        clearRacePhotoTable();
        RacePhoto racePhoto = new RacePhoto();
        racePhoto = fillRacePhoto();
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertEquals(1, racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertEquals(RACE_PHOTO_PATH, racePhotoSelected.getPath());
        assertNotNull(racePhotoSelected.getUser().getId());
        assertNotNull(racePhotoSelected.getRace().getId());
        log.info(racePhoto);
    }

    @Test
    public void testUpdate(){
        log.info("testing update RacePhoto()...");
        clearRacePhotoTable();
        RacePhoto racePhoto = new RacePhoto();
        racePhoto = fillRacePhoto();
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        racePhoto = fillUpdatedRacePhoto();
        racePhoto.setId(racePhotos.get(0).getId());
        racePhotoDao.update(racePhoto);
        racePhotos = racePhotoDao.selectAll();
        assertEquals(1, racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertEquals(RACE_PHOTO_PATH_UPDATE, racePhotoSelected.getPath());
        assertNotNull(racePhotoSelected.getUser().getId());
        assertNotNull(racePhotoSelected.getRace().getId());

        log.info(racePhotos);
    }

    @Test
    public void testDelete(){
        log.info("testing delete RacePhoto()...");
        clearRacePhotoTable();
        RacePhoto racePhoto = new RacePhoto();
        racePhoto = fillRacePhoto();
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertNotNull(racePhotos.get(0));
        racePhotoDao.delete(racePhotos.get(0));
        racePhotos = racePhotoDao.selectAll();
        assertEquals(0,racePhotos.size());
    }

    private RacePhoto fillRacePhoto(){
        User user = userDao.selectAll().get(0);
        Race race = new Race();
        race.setId(1); //TODO: When raceDao implemented, change to dao query
        RacePhoto racePhoto = new RacePhoto();
        racePhoto.setPath(RACE_PHOTO_PATH);
        racePhoto.setRace(race);
        racePhoto.setUser(user);
        return racePhoto;
    }

      private RacePhoto fillUpdatedRacePhoto() {
        User user = userDao.selectAll().get(1);
        Race race = new Race();
        race.setId(2);
        RacePhoto racePhoto = new RacePhoto();
        racePhoto.setPath(RACE_PHOTO_PATH_UPDATE);
        racePhoto.setUser(user);
        racePhoto.setRace(race);
        return racePhoto;
    }

    private void clearRacePhotoTable(){
        List<RacePhoto> result =  racePhotoDao.selectAll();
        for(int i=0;i<result.size();i++)
            racePhotoDao.delete(result.get(i));
    }
}
