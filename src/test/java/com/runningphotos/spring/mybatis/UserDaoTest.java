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
@ContextConfiguration(locations = "/spring-config.xml")



public class UserDaoTest extends TestData {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @Test

    public void testInsertRole(){
        log.info("testing insert User()...");
        userDao.clearUserTable();
        User user = new User();
        user.setName(USERNAME);
        user.setSurname(USER_SURNAME);
        user.setLogin(USER_LOGIN);
        user.setBirthDate(USER_BIRTHDAY);
        user.setCity(USER_CITY);
        user.setMail(USER_MAIL);
        Role userRole = roleDao.selectAllRoles().get(0);
        user.setRole(userRole);
        assertEquals(0, userDao.selectAllUsers().size());
        userDao.insert(user);
        List<User> users = userDao.selectAllUsers();
        System.out.println(users+"first test");
        assertEquals(1, users.size());
        user = users.get(0);
        assertEquals(USERNAME, user.getName());
        assertEquals(USER_SURNAME, user.getSurname());
        assertEquals(USER_LOGIN, user.getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY), dateFormat.format(user.getBirthDate()));
        assertEquals(USER_CITY, user.getCity());
        assertEquals(USER_MAIL,user.getMail());
        assertEquals(userRole.getId(),user.getRole().getId());
        log.info(users);
    }

    @Test
    public void testUpdate(){
        log.info("testing update User()...");
        userDao.clearUserTable();
        User user = new User();
        user.setName(USERNAME_UPDATE);
        user.setSurname(USER_SURNAME_UPDATE);
        user.setLogin(USER_LOGIN_UPDATE);
        user.setBirthDate(USER_BIRTHDAY_UPDATE);
        user.setCity(USER_CITY_UPDATE);
        user.setMail(USER_MAIL_UPDATE);
        Role userRole = roleDao.selectAllRoles().get(0);
        user.setRole(userRole);
        userDao.insert(user);
        user.setId(1);

        userDao.update(user);
        List<User> users = userDao.selectAllUsers();
        System.out.println(users + "second Test");
        assertEquals(USERNAME_UPDATE, users.get(0).getName());
        assertEquals(USER_SURNAME_UPDATE, user.getSurname());
        assertEquals(USER_LOGIN_UPDATE, user.getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY_UPDATE), dateFormat.format(user.getBirthDate()));
        assertEquals(USER_CITY_UPDATE, user.getCity());
        assertEquals(USER_MAIL_UPDATE,user.getMail());
        assertEquals(userRole.getId(),user.getRole().getId());
        log.info(users);
    }
   @Test
   public void deleteTest(){
       userDao.clearUserTable();
        log.info("testing delete User()...");
        User user = new User();
       user.setName(USERNAME_UPDATE);
       user.setSurname(USER_SURNAME_UPDATE);
       user.setLogin(USER_LOGIN_UPDATE);
       user.setBirthDate(USER_BIRTHDAY_UPDATE);
       user.setCity(USER_CITY_UPDATE);
       user.setMail(USER_MAIL_UPDATE);
       Role userRole = roleDao.selectAllRoles().get(0);
       user.setRole(userRole);
       userDao.insert(user);
       userDao.getById(1);
       assertNotNull(user);
       user.setId(1);
       userDao.delete(user);
       assertNull(userDao.getById(1));

}
}
