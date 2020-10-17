package com.kodilla.patterns2.observer.homework;

public interface WatchedStudents {
    void registerMentor(Mentor mentor);
    void notifyMentors();
    void removeMentor(Mentor mentor);
}
