package com.kodilla.patterns2.observer.homework;

public class JavaMentor implements Mentor {

    private final String mentorName;
    private int updateCount;

    public JavaMentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        updateCount++;
        System.out.println(getMentorName() + ": New update on Java course. Your student " + student.getName() +
                " finished homework number " + updateCount + "\n" +
                " (total: " + student.getHomeworks().size() + " homeworks done)");
    }

    public String getMentorName() {
        return "Mr. " + mentorName;
    }

    @Override
    public int getUpdateCount() {
        return updateCount;
    }
}
