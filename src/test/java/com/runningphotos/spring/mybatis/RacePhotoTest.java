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

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private RacePhotoDao racePhotoDao;
    @Autowired
    private UserDao userDao;
  //  @Autowired
   // private RaceDao raceDao;

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
        assertEquals(RACE_PHOTO_PATH_UPDATE, racePhotos.get(0).getPath());
        assertEquals(racePhoto.getUser().getId(), racePhotos.get(0).getUser().getId());
        assertEquals(racePhoto.getRace().getId(), racePhotos.get(0).getRace().getId());

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
    @Test
    public void testInsert(){
        log.info("testing insert RacePhoto()...");
        clearRacePhotoTable();
        RacePhoto racePhoto = new RacePhoto();
        racePhoto = fillRacePhoto();
        racePhotoDao.insert(racePhoto);
        List<RacePhoto> racePhotos = racePhotoDao.selectAll();
        assertEquals(1, racePhotos.size());
        assertEquals(RACE_PHOTO_PATH, racePhotos.get(0).getPath());
        assertEquals(racePhoto.getRace().getId(),racePhotos.get(0).getUser().getId());
        log.info(racePhoto);
    }

    private RacePhoto fillRacePhoto(){
        User user = new User();
        user.setName(USERNAME);
        user.setSurname(USER_SURNAME);
        user.setBirthDate(USER_BIRTHDAY);
        user.setCity(USER_CITY);
        user.setLogin(USER_LOGIN);
        user.setMail(USER_MAIL);

        Race race = new Race();
        race.setName(RACE_NAME);
        race.setCity(RACE_CITY);
        race.setRaceDate(RACE_DATE);
        race.setId(1); // delete



        RacePhoto racePhoto = new RacePhoto();
        List<User> users =  userDao.selectAll();
        List<Race> racers = new ArrayList<Race>(); // = raceDao.selectALL();
        racers.add(race); // delete
        user=users.get(0);
        race=racers.get(0);
        racePhoto.setPath(RACE_PHOTO_PATH);
        racePhoto.setRace(race);
        racePhoto.setUser(user);
        return racePhoto;
    }

      private RacePhoto fillUpdatedRacePhoto() {
        User user = new User();
        user.setName(USERNAME_UPDATE);
        user.setSurname(USER_SURNAME_UPDATE);
        user.setBirthDate(USER_BIRTHDAY_UPDATE);
        user.setCity(USER_CITY_UPDATE);
        user.setLogin(USER_LOGIN_UPDATE);
        user.setMail(USER_MAIL_UPDATE);

        Race race = new Race();
        race.setName(RACE_NAME_UPDATE);
        race.setCity(RACE_CITY_UPDATE);
        race.setRaceDate(RACE_DATE_UPDATE);
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
