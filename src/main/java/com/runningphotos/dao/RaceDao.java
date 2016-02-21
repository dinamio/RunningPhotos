package com.runningphotos.dao;

import com.runningphotos.bom.Race;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Overdark on 27.12.2015.
 */
public interface RaceDao extends MyBatisDao<Race> {

    List<Race>searchContainsName(@Param("raceCriteria")List<String> raceCriteria);

    List<Race> selectRacesWithoutResult();
}
