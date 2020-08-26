package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private String taskName;
    String color;
    String whatToPaint;
    private boolean taskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {
        taskExecuted = true;
        return "Task " + getTaskName() + " is executed: paint " + getWhatToPaint() + " in color " + getColor();
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }
}
