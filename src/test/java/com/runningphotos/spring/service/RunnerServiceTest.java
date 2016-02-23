package com.runningphotos.spring.service;

import com.runningphotos.AbstractTest;
import com.runningphotos.bom.Runner;
import com.runningphotos.service.RunnerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by eugenegodun on 2/23/16.
 */
public class RunnerServiceTest extends AbstractTest {

    @Autowired
    RunnerService runnerService;

    @Test
    public void testInsertRunnerIfNotExists() {
        Runner runner = createMockRunner();
        Runner resultRunner = runnerService.insertRunnerIfNotExists(runner);
        assertNotNull(resultRunner.getId());
        Integer id = resultRunner.getId();
        resultRunner = runnerService.insertRunnerIfNotExists(resultRunner);
        assertNotNull(resultRunner.getId());
        assertEquals(id,resultRunner.getId());
    }

    private Runner createMockRunner() {
        Runner runner = new Runner();
        runner.setName(RUNNER_NAME);
        runner.setSurname(RUNNER_SURNAME);
        return runner;
    }
}
