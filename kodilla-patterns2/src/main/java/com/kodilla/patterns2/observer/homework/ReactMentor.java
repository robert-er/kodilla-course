package com.kodilla.patterns2.observer.homework;

public class ReactMentor implements Mentor {

    private final String mentorName;
    private int updateCount;

    public ReactMentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        System.out.println("Hi " + getMentorName() + ". You have something to check on <<React course>> from your student " +
                student.getName() + "\n" +
                " (total: " + student.getHomeworks().size() + " homeworks done)");
        updateCount++;
    }

    public String getMentorName() {
        return "mr." + mentorName;
    }

    @Override
    public int getUpdateCount() {
        return updateCount;
    }
}
