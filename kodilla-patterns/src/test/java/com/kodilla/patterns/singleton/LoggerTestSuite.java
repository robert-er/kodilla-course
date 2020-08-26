package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLogTest() {
        //Given
        //Logger logger = new Logger();
        //When
        Logger.getInstance().log("this is log");
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("this is log", result);
    }
}
