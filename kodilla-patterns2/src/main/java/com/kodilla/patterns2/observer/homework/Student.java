package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements WatchedStudents {

    private final List<Mentor> mentors;
    private final List<String> homeworks;
    private final String name;

    public Student(String name) {
        mentors = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyMentors();
    }

    @Override
    public void registerMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyMentors() {
        for(Mentor mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentors.remove(mentor);
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }
}
