package com.runningphotos.dao;

import com.runningphotos.bom.Entity;
import com.runningphotos.bom.User;

import java.util.List;

/**
 * Created by Николай on 17.12.2015.
 */
public interface MyBatisDao<T extends Entity> {
    //
    void insert(T variable);

    List<T> selectAll();

    void update(T variable);

    void delete(T variable);

    T getById(int id);
}
