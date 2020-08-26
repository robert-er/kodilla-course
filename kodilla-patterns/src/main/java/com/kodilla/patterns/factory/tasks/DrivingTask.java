package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private String taskName;
    String where;
    String using;
    private boolean taskExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        taskExecuted = true;
        return "Task " + getTaskName() + " is executed: driving " + getWhere() + " by " + getUsing();
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
