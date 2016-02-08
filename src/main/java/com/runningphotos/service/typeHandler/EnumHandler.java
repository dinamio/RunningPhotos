package com.runningphotos.service.typeHandler;

/**
 * Created by Николай on 07.02.2016.
 */
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.runningphotos.bom.Role;

/**
 * Created by Николай on 07.02.2016.
 */
public class EnumHandler implements TypeHandler<Role> {


    public void setParameter(PreparedStatement preparedStatement, int i, Role role, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, role.getId());
    }

    public Role getResult(ResultSet resultSet, String s) throws SQLException {
        for (Role role: Role.values()) {
            if (role.getId() == resultSet.getInt(s))
                return role;
        }
        return null;
    }

    public Role getResult(ResultSet resultSet, int i) throws SQLException {
        for (Role role: Role.values()) {
            if (role.getId() == resultSet.getInt(i))
                return role;
        }
        return null;
    }

    public Role getResult(CallableStatement callableStatement, int i) throws SQLException {
        for (Role role : Role.values()) {
            if (role.getId() == callableStatement.getInt(i))
                return role;
        }
        return null;
    }
}