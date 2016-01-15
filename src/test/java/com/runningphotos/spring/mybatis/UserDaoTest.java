package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.bom.Role;
import com.runningphotos.bom.User;
import com.runningphotos.dao.RoleDao;
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
@ContextConfiguration(locations = "/applicationContext.xml")


//
public class UserDaoTest extends TestData {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @Test
    public void testRun(){
        testInsert();
        testUpdate();
        deleteTest();
    }


    private void testInsert(){
        log.info("testing insert User()...");
        User user = fillUser();
        userDao.insert(user);
        List<User> users = userDao.selectAll();
        System.out.println(users+"first test");
        assertEquals(3, users.size());
        user = users.get(2);
        assertEquals(USERNAME, user.getName());
        assertEquals(USER_SURNAME, user.getSurname());
        assertEquals(USER_LOGIN, user.getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY), dateFormat.format(user.getBirthDate()));
        assertEquals(USER_CITY, user.getCity());
        assertEquals(USER_MAIL,user.getMail());
        assertEquals(user.getRole().getId(),user.getRole().getId());
        log.info(users);
    }

    private void testUpdate(){
        log.info("testing update User()...");
        List<User> users = userDao.selectAll();
        User user = fillUpdatedUser();
        user.setId(users.get(2).getId());
        userDao.update(user);
         users = userDao.selectAll();
        System.out.println(users.get(2) + " second Test");
        assertEquals(USERNAME_UPDATE, users.get(2).getName());
        assertEquals(USER_SURNAME_UPDATE, users.get(2).getSurname());
        assertEquals(USER_LOGIN_UPDATE, users.get(2).getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY_UPDATE), dateFormat.format(users.get(2).getBirthDate()));
        assertEquals(USER_CITY_UPDATE, users.get(2).getCity());
        assertEquals(USER_MAIL_UPDATE,users.get(2).getMail());
        assertEquals(user.getRole().getId(),users.get(2).getRole().getId());
        log.info(users);
    }

    private void deleteTest(){
        log.info("testing delete User()...");
        List<User> users = userDao.selectAll();
        assertNotNull(users.get(2));
        userDao.delete(users.get(2));
        users = userDao.selectAll();
        assertEquals(2,users.size());
}
    private User fillUpdatedUser(){
        User user = new User();
        user.setName(USERNAME_UPDATE);
        user.setSurname(USER_SURNAME_UPDATE);
        user.setLogin(USER_LOGIN_UPDATE);
        user.setBirthDate(USER_BIRTHDAY_UPDATE);
        user.setCity(USER_CITY_UPDATE);
        user.setMail(USER_MAIL_UPDATE);
        //Role userRole = roleDao.selectAllRoles().get(0);
        user.setRole(roleDao.selectAllRoles().get(0));
        return user;
    }
    private User fillUser(){
        User user = new User();
        user.setName(USERNAME);
        user.setSurname(USER_SURNAME);
        user.setLogin(USER_LOGIN);
        user.setBirthDate(USER_BIRTHDAY);
        user.setCity(USER_CITY);
        user.setMail(USER_MAIL);
        //Role userRole = roleDao.selectAllRoles().get(0);
        user.setRole(roleDao.selectAllRoles().get(0));
        return user;
    }

}
