package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private final Student littleJoe = new Student("Little Joe");
    private final Student bigSue = new Student("Big Sue");
    private final Mentor javaTeacher = new JavaMentor("Java Master");
    private final Mentor reactTeacher = new ReactMentor("React Guru");

    @Test
    public void testUpdate() {
        //Given
        createTestData();
        //When
        int javaTeacherJobs = javaTeacher.getUpdateCount();
        int reactTeacherJobs = reactTeacher.getUpdateCount();
        //Then
        assertEquals(7, javaTeacherJobs);
        assertEquals(3, reactTeacherJobs);
    }

    private void createTestData() {
        littleJoe.registerMentor(javaTeacher);
        littleJoe.registerMentor(reactTeacher);
        bigSue.registerMentor(javaTeacher);

        littleJoe.addHomework("Hello World");
        littleJoe.addHomework("First web with Hello World");
        littleJoe.addHomework("Skip basics, do advanced web service");

        bigSue.addHomework("Hello World");
        bigSue.addHomework("Hello World in two lines");
        bigSue.addHomework("Extract Hello World to another class");
        bigSue.addHomework("Use if - Hello World in two languages");
    }
}