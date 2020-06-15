package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests of class " + StatisticsCalculator.class);
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<String> generateUsers(int amount) {
        List<String> userList = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            userList.add("user" + i);
        }
        return userList;
    }

    @Test
    public void testCalculateAdvStatisticsAllZeros() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, statisticsCalculator.getUserCounter());
        Assert.assertEquals(0, statisticsCalculator.getPostCounter());
        Assert.assertEquals(0, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics1000PostsOtherZeros() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(0, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics500CommentsOtherZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(500);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, statisticsCalculator.getUserCounter());
        Assert.assertEquals(0, statisticsCalculator.getPostCounter());
        Assert.assertEquals(500, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics0Users1000Posts500Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(500, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.5, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics0Users1000Posts2000Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(2000, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(2.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics100UsersOtherZeros() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, statisticsCalculator.getUserCounter());
        Assert.assertEquals(0, statisticsCalculator.getPostCounter());
        Assert.assertEquals(0, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics100Users0Posts500Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(500);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, statisticsCalculator.getUserCounter());
        Assert.assertEquals(0, statisticsCalculator.getPostCounter());
        Assert.assertEquals(500, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(0.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(5.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics100Users1000Posts0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(0, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(10.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics100Users1000Posts500Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(500, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(10.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(5.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(0.5, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatistics100Users1000Posts2000Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, statisticsCalculator.getUserCounter());
        Assert.assertEquals(1000, statisticsCalculator.getPostCounter());
        Assert.assertEquals(2000, statisticsCalculator.getCommentCounter());
        Assert.assertEquals(10.0, statisticsCalculator.getAveragePostPerUser(), 0.0);
        Assert.assertEquals(20.0, statisticsCalculator.getAverageCommentPerUser(), 0.0);
        Assert.assertEquals(2.0, statisticsCalculator.getAverageCommentPerPost(), 0.0);
    }
}
