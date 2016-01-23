package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.bom.Role;
        import com.runningphotos.dao.RoleDao;
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
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class RoleDaoTest {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testInsertRole(){
        log.info("testing insert Role()...");
        Role role = new Role();
        role.setName("Admin");
        roleDao.insert(role);
        List<Role> roles = roleDao.selectAllRoles();
        assertEquals(5,roles.size());
        assertEquals(roles.get(4).getName(),"Admin");
        log.info(roles);
    }
}
