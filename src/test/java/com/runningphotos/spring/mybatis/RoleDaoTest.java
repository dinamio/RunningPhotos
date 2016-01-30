package com.runningphotos.spring.mybatis;

/**
 * Created by Jimmy on 12.12.2015.
 */

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Role;
import com.runningphotos.dao.RoleDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class RoleDaoTest extends AbstractTest {

    private static Log log = LogFactory.getLog(RoleDaoTest.class);

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
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
