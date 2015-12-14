package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.bom.Role;
import com.runningphotos.bom.User;
import com.runningphotos.dao.RoleDao;
import com.runningphotos.dao.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class UserDaoTest {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertRole(){
        log.info("testing insert User()...");

        User user = new User();

        User anotherUser = new User();

        user.setId(1);
        anotherUser.setId(2);
        user.setName("Runner");
        user.setSurname("Runnerov");
        userDao.insert(user);
        user.setName("updut");
        userDao.update(user);
        anotherUser.setName("anyAnotherUser");
        anotherUser.setSurname("anyAnotherUserSurname");
        userDao.insert(anotherUser);
        userDao.delete(anotherUser);
        List<User> users = userDao.selectAllUsers();
        assertEquals(users.get(0).getName(),"updut");
        assertEquals(users.size(),1);
        log.info(users);
    }
}
