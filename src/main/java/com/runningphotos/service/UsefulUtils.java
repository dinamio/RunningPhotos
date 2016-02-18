package com.runningphotos.service;

import com.runningphotos.bom.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenegodun on 2/18/16.
 */
public class UsefulUtils {

    public static List<String> getDistancesByResults(List<Result> results) {
        List<String> distances = new ArrayList<String>();
        for(Result result : results) {
            if(!distances.contains(result.getDistance().getName()))
                distances.add(result.getDistance().getName());
        }
        return distances;
    }
}
