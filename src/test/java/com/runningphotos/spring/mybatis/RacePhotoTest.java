package com.runningphotos.spring.mybatis;

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Race;
import com.runningphotos.bom.RacePhoto;

import com.runningphotos.bom.User;
import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.RacePhotoDao;


import com.runningphotos.dao.RunnerDao;
import com.runningphotos.dao.UserDao;
import com.runningphotos.testdata.TestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zOpa on 22.12.2015.
 */
public class RacePhotoTest extends AbstractTest {

    private static Log log = LogFactory.getLog(RacePhotoTest.class);

    @Autowired
    private RacePhotoDao racePhotoDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RaceDao raceDao;
    @Autowired
    private RunnerDao runnerDao;

    @Test
    public void testRun(){
        testInsert();
        testSelectAll();
        testGetAllAuthorPhotos();
        testUpdate();
        testDelete();
    }


    private void testSelectAll(){
        log.info("testing selectAll RacePhoto()...");
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertNotNull(racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertNotNull(racePhotoSelected.getPath());
        assertEquals(1, racePhotoSelected.getRunnersMarked().size());

    }

    private void testGetAllAuthorPhotos(){
        log.info("testing getAllAuthorPhotos()...");
        User author = userDao.selectAll().get(0);
        List<RacePhoto> racePhotos = racePhotoDao.getAllAuthorPhotos(author);
        assertNotNull(racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertNotNull(racePhotoSelected.getPath());
        assertEquals(1,racePhotoSelected.getRunnersMarked().size());
        assertEquals(author.getId(),racePhotoSelected.getUser().getId());
    }

    private void testInsert(){
        log.info("testing insert RacePhoto()...");
        RacePhoto racePhoto = fillRacePhoto(RACE_PHOTO_PATH);
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertEquals(2, racePhotos.size());
        RacePhoto racePhotoSelected = racePhotos.get(0);
        assertEquals(RACE_PHOTO_PATH, racePhotoSelected.getPath());
        assertNotNull(racePhotoSelected.getUser().getId());
        assertNotNull(racePhotoSelected.getRace().getId());
        log.info(racePhoto);
    }

    private void testUpdate(){
        log.info("testing update RacePhoto()...");
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        RacePhoto racePhoto = fillRacePhoto(RACE_PHOTO_PATH);
        racePhotoDao.insert(racePhoto);
        assertEquals(RACE_PHOTO_PATH,racePhotos.get(0).getPath());
        RacePhoto updateRacePhoto = fillRacePhoto(RACE_PHOTO_PATH_UPDATE);
        racePhotoDao.update(updateRacePhoto);
        updateRacePhoto.setId(racePhotos.get(0).getId());
        racePhotos = racePhotoDao.selectAll();
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
        assertEquals(2,racePhotos.size());
    }

    private RacePhoto fillRacePhoto(String path){
        User user = userDao.selectAll().get(0);
        Race race = raceDao.selectAll().get(0);
        RacePhoto racePhoto = new RacePhoto();
        racePhoto.setPath(path);
        racePhoto.setRace(race);
        racePhoto.setUser(user);
        racePhoto.setRunnersMarked(runnerDao.selectAll());
        return racePhoto;
    }
}
