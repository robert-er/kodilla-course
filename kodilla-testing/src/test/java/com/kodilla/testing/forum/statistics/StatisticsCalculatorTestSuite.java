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

    private int generate0Posts() {
        return 0;
    }

    private int generate1000Posts() {
        return 1000;
    }

    private int generate0Comments() {
        return 0;
    }

    private int generate500Comments() {
        return 500;
    }

    private int generate2000Comments() {
        return 2000;
    }

    private List<String> generate0Users() {
        List<String> userList = new ArrayList<>();
        return userList;
    }

    private List<String> generate100Users() {
        List<String> userList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            userList.add("user" + i);
        }
        return userList;
    }

    @Test
    public void testCalculateAdvStatisticsAllZeros() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.usersNames()).thenReturn(generate0Users());
        when(statisticsMock.postsCount()).thenReturn(generate0Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate0Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate0Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate0Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate0Users());
        when(statisticsMock.postsCount()).thenReturn(generate0Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate500Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate0Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate500Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate0Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate2000Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate100Users());
        when(statisticsMock.postsCount()).thenReturn(generate0Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate0Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate100Users());
        when(statisticsMock.postsCount()).thenReturn(generate0Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate500Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate100Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate0Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate100Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate500Comments());
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
        when(statisticsMock.usersNames()).thenReturn(generate100Users());
        when(statisticsMock.postsCount()).thenReturn(generate1000Posts());
        when(statisticsMock.commentsCount()).thenReturn(generate2000Comments());
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
