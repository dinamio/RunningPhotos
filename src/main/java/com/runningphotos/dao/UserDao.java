package com.runningphotos.dao;

import com.runningphotos.bom.User;

import java.util.List;

/**
 * Created by ������� on 14.12.2015.
 */
public interface UserDao extends MyBatisDao<User> {

    User selectByUsername(String username);
    User selectByMail(User user);

}
