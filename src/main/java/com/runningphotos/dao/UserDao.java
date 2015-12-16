package com.runningphotos.dao;

import com.runningphotos.bom.User;

import java.util.List;

/**
 * Created by Николай on 14.12.2015.
 */
public interface UserDao {

    void insert(User user);

    List<User> selectAllUsers();

    void update(User user);

    void delete(User user);

    User getById(int id);
}
