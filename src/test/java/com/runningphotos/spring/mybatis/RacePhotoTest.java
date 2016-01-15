package com.runningphotos.spring.mybatis;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.RacePhoto;

import com.runningphotos.bom.User;
import com.runningphotos.dao.RaceDao;
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
@ContextConfiguration(locations = "/applicationContext.xml")
public class RacePhotoTest extends TestData {

    private static Log log = LogFactory.getLog(RacePhotoTest.class);

    @Autowired
    private RacePhotoDao racePhotoDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RaceDao raceDao;

    @Test
    public void testRun(){
        testInsert();
        testUpdate();
        testDelete();
    }


    private void testInsert(){
        log.info("testing insert RacePhoto()...");
        RacePhoto racePhoto = fillRacePhoto(RACE_PHOTO_PATH);
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertEquals(1, racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertEquals(RACE_PHOTO_PATH, racePhotoSelected.getPath());
        assertNotNull(racePhotoSelected.getUser().getId());
        assertNotNull(racePhotoSelected.getRace().getId());
        log.info(racePhoto);
    }

    private void testUpdate(){
        log.info("testing update RacePhoto()...");
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        RacePhoto racePhoto = fillRacePhoto(RACE_PHOTO_PATH_UPDATE);
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

    private void testDelete(){
        log.info("testing delete RacePhoto()...");
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertNotNull(racePhotos.get(0));
        racePhotoDao.delete(racePhotos.get(0));
        racePhotos = racePhotoDao.selectAll();
        assertEquals(0,racePhotos.size());
    }
    // �������� ����� �� �������
    private RacePhoto fillRacePhoto(String path){
        User user = userDao.selectAll().get(0);
        Race race = raceDao.selectAll().get(0);
        RacePhoto racePhoto = new RacePhoto();
        racePhoto.setPath(path);
        racePhoto.setRace(race);
        racePhoto.setUser(user);
        return racePhoto;
    }

}
