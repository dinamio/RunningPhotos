package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Role;
import com.runningphotos.bom.User;
import com.runningphotos.dao.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class UserDaoTest extends AbstractTest {

    private static Log log = LogFactory.getLog(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

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
        assertEquals(user.getRole(),Role.RUNNER);
        log.info(users);
    }

    private void testUpdate(){
        log.info("testing update User()...");
        List<User> users = userDao.selectAll();
        User user = fillUpdatedUser();
        user.setId(users.get(2).getId());
        userDao.update(user);
         users = userDao.selectAll();
        System.out.println(users.get(2)+" "+user.getRole().getId()+" " + " second Test");
        assertEquals(USERNAME_UPDATE, users.get(2).getName());
        assertEquals(USER_SURNAME_UPDATE, users.get(2).getSurname());
        assertEquals(USER_LOGIN_UPDATE, users.get(2).getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY_UPDATE), dateFormat.format(users.get(2).getBirthDate()));
        assertEquals(USER_CITY_UPDATE, users.get(2).getCity());
        assertEquals(USER_MAIL_UPDATE,users.get(2).getMail());
        assertEquals(user.getRole(),Role.PHOTOGRAPHER);
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
        //user.setRole(roleDao.selectAllRoles().get(0));
        Role role = Role.PHOTOGRAPHER;
        user.setRole(role);
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
        //user.setRole(roleDao.selectAllRoles().get(0));
        Role role = Role.RUNNER;
        user.setRole(role);

        return user;
    }

}
