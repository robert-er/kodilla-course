package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "not done";
        try {
            result = secondChallenge.probablyIWillThrowException(5, 1);
        } catch (Exception e) {
            System.out.println("wystapil wyjatek: " + e);
        } finally {
            System.out.println(result);
        }
    }
}
