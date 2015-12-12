package com.runningphotos.dao;

import com.runningphotos.bom.Role;

import java.util.List;

/**
 * Created by Jimmy on 12.12.2015.
 */
public interface RoleDao {

    void insert(Role role);

    List<Role> selectAllRoles();
}
