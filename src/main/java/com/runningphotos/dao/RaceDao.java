package com.runningphotos.dao;

import com.runningphotos.bom.Race;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Overdark on 27.12.2015.
 */
public interface RaceDao extends MyBatisDao<Race> {

    Race selectByName(String raceName);

    List<Race> searchContainsName(@Param("raceCriteria")String raceCriteria);

    List<Race> selectRacesWithoutResult();
    List<Race> selectRacesWithResult();
}
