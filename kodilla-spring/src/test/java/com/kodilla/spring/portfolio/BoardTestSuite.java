package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testAddTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addTaskToDoList("new task");
        board.addTaskDoneList("done task");
        board.addTaskInProgressList("in progress task");
        boolean resultToDo = board.getToDoList().getTasks().contains("new task");
        boolean resultDone = board.getDoneList().getTasks().contains("done task");
        boolean resultInProgress = board.getInProgressList().getTasks().contains("in progress task");
        //Then
        Assert.assertTrue(resultToDo);
        Assert.assertTrue(resultDone);
        Assert.assertTrue(resultInProgress);
    }
}
