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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        User user = new User();
        user.setName(USERNAME);
        user.setSurname(USER_SURNAME);
        user.setLogin(USER_LOGIN);
        user.setBirthDate(USER_BIRTHDAY);
        user.setCity(USER_CITY);
        user.setMail(USER_MAIL);
        Role userRole = roleDao.selectAllRoles().get(0);
        user.setRole(userRole);
        assertEquals(0,userDao.selectAllUsers().size());
        userDao.insert(user);
        List<User> users = userDao.selectAllUsers();
        assertEquals(1,users.size());
        user = users.get(0);
        assertEquals(USERNAME,user.getName());
        assertEquals(USER_SURNAME,user.getSurname());
        assertEquals(USER_LOGIN,user.getLogin());
        assertEquals(dateFormat.format(USER_BIRTHDAY),dateFormat.format(user.getBirthDate()));
        assertEquals(USER_CITY,user.getCity());
        assertEquals(USER_MAIL,user.getMail());
        assertEquals(userRole.getId(),user.getRole().getId());
        log.info(users);
    }
}
