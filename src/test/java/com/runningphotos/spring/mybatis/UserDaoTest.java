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
   //lets commit
    public void testInsertRole(){
        log.info("testing insert User()...");
        clearUserTable();
        User user = new User();
        user = fillUser();
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
        assertEquals(user.getRole().getId(),user.getRole().getId());
        log.info(users);
    }

    @Test
    public void testUpdate(){
        log.info("testing update User()...");
        clearUserTable();
        User user = new User();
        user = fillUser();
        userDao.insert(user);
        List<User> users = userDao.selectAllUsers();


        user = fillUpdatedUser();
        user.setId(users.get(0).getId());

        userDao.update(user);
         users = userDao.selectAllUsers();
        System.out.println(users.get(0) + " second Test");
        assertEquals(USERNAME_UPDATE, users.get(0).getName());
        assertEquals(USER_SURNAME_UPDATE, users.get(0).getSurname());
        assertEquals(USER_LOGIN_UPDATE, users.get(0).getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY_UPDATE), dateFormat.format(users.get(0).getBirthDate()));
        assertEquals(USER_CITY_UPDATE, users.get(0).getCity());
        assertEquals(USER_MAIL_UPDATE,users.get(0).getMail());
        assertEquals(user.getRole().getId(),users.get(0).getRole().getId());
        log.info(users);
    }
  @Test
   public void deleteTest(){
        log.info("testing delete User()...");
        clearUserTable();
        User user = new User();
        user = fillUser();
        userDao.insert(user);
        List<User> users = userDao.selectAllUsers();

        assertNotNull(users.get(0));

        userDao.delete(users.get(0));
        users = userDao.selectAllUsers();
        assertEquals(0,users.size());
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

    private void clearUserTable(){
        List<User > result =  userDao.selectAllUsers();
        for(int i=0;i<result.size();i++)
            userDao.delete(result.get(i));
    }
}
