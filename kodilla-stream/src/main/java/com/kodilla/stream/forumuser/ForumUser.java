package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private int postCounter;
    private static int idCounter = 0;

    public ForumUser(final String name, final char sex, final LocalDate birthDate) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        for(int i = 0; i < idCounter * 2 && idCounter % 2 == 0; i++) {
            publicPost();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCounter() {
        return postCounter;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void publicPost() {
        postCounter++;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postCounter=" + postCounter +
                '}';
    }
}
