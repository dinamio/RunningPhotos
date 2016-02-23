package com.runningphotos.service;

import com.runningphotos.bom.Distance;
import com.runningphotos.bom.Runner;
import com.runningphotos.dao.DistanceDao;
import com.runningphotos.dao.RunnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eugenegodun on 2/23/16.
 */
@Service
public class DistanceService {

    @Autowired
    private DistanceDao distanceDao;


    public Distance insertDistanceIfNotExists(Distance distance) {
        Distance fromDatabase = distanceDao.findDistance(distance);
        if (fromDatabase == null) {
            distanceDao.insert(distance);
            return distance;
        }
        return fromDatabase;
    }

}
