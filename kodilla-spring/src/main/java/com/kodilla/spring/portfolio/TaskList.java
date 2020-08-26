package com.kodilla.spring.portfolio;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

}
