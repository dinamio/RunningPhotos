package com.runningphotos;

import com.runningphotos.testdata.TestData;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jimmy on 24.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-context.xml")
public abstract class AbstractTest extends TestData {
}
