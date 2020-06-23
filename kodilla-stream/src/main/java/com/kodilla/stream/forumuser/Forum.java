package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser("Adam Kowalski", 'M', LocalDate.of(1999, 1, 5)));
        theUserList.add(new ForumUser("Alicja Kowalska", 'F', LocalDate.of(1979, 5, 14)));
        theUserList.add(new ForumUser("Janina Nowak", 'F', LocalDate.of(1966, 12, 7)));
        theUserList.add(new ForumUser("Brajan Nowak", 'M', LocalDate.of(2006, 7, 20)));
        theUserList.add(new ForumUser("Dzesika Bobak", 'F', LocalDate.of(2004, 10, 3)));
        theUserList.add(new ForumUser("Jakub Majewski", 'M', LocalDate.of(1992, 4, 24)));
        theUserList.add(new ForumUser("Weronika Niezgoda", 'F', LocalDate.of(1981, 11, 12)));
        theUserList.add(new ForumUser("Janusz Wasowicz", 'M', LocalDate.of(1956, 2, 12)));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
