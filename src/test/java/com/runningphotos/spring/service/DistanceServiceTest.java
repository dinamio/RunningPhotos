package com.runningphotos.spring.service;

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Distance;
import com.runningphotos.service.DistanceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by eugenegodun on 2/23/16.
 */
public class DistanceServiceTest extends AbstractTest {


    @Autowired
    DistanceService distanceService;

    @Test
    public void testInsertDistanceIfNotExists() {
        Distance distance = createMockDistance();
        Distance resultDistance = distanceService.insertDistanceIfNotExists(distance);
        assertNotNull(resultDistance.getId());
        Integer id = resultDistance.getId();
        resultDistance = distanceService.insertDistanceIfNotExists(resultDistance);
        assertNotNull(resultDistance.getId());
        assertEquals(id, resultDistance.getId());
    }

    private Distance createMockDistance() {
        Distance distance = new Distance();
        distance.setName(DISTANCE_NAME);
        distance.setLength(DISTANCE_LENGHT);
        return distance;
    }
}
