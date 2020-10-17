package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumUserTest {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnny = new ForumUser("Johnny");
        ForumUser ivonne = new ForumUser("Ivonne");
        ForumUser matilde = new ForumUser("Matilde");
        javaHelpForum.registerObserver(johnny);
        javaToolsForum.registerObserver(ivonne);
        javaHelpForum.registerObserver(matilde);
        javaToolsForum.registerObserver(matilde);
        //When
        javaHelpForum.addPost("Hi everyone! Could you help me with the loop?");
        javaHelpForum.addPost("Better try to use while");
        javaToolsForum.addPost("Help pls with MySQL");
        javaHelpForum.addPost("Why while? I dont like your idea");
        javaToolsForum.addPost("When I try to log in I got new six-pack beer on my table. Is this standard feature?");
        //Then
        assertEquals(3, johnny.getUpdateCount());
        assertEquals(2, ivonne.getUpdateCount());
        assertEquals(5, matilde.getUpdateCount());
    }

}