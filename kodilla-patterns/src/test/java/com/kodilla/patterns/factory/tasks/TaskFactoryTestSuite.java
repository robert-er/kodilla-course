package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeShape("SHOPPING");
        //Then
        Assert.assertEquals("Shopping list", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
        Assert.assertEquals("Task Shopping list is executed: buy 25.0 of food", shopping.executeTask());
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeShape("PAINTING");
        //Then
        Assert.assertEquals("Paint wall", painting.getTaskName());
        Assert.assertFalse(painting.isTaskExecuted());
        Assert.assertEquals("Task Paint wall is executed: paint wall in color white", painting.executeTask());
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeShape("DRIVING");
        //Then
        Assert.assertEquals("Pick girlfriend from work", driving.getTaskName());
        Assert.assertFalse(driving.isTaskExecuted());
        Assert.assertEquals("Task Pick girlfriend from work is executed: driving her work by car",
                driving.executeTask());
        Assert.assertTrue(driving.isTaskExecuted());
    }
}
