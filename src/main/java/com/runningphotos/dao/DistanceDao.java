package com.runningphotos.dao;

import com.runningphotos.bom.Distance;

/**
 * Created by Oleg on 04.01.2016.
 */
public interface DistanceDao extends MyBatisDao<Distance> {

    Distance findDistance(Distance distance);

}
