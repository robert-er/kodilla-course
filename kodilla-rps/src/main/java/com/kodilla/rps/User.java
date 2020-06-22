package com.kodilla.rps;

public class User {
    private final String name;
    private final int rounds;
    private int joker;
    private int difficulty;

    public User(String name, int rounds, int joker, int difficulty) {
        this.name = name;
        this.rounds = rounds;
        this.joker = joker;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public int getRounds() {
        return rounds;
    }

    public int getJoker() {
        return joker;
    }

    public void setJoker(int joker) {
        this.joker = joker;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return  "Gracz='" + name + '\'' +
                ", ilość rund=" + rounds +
                ", jokerów=" + joker +
                ", trudność=" + difficulty;
    }
}
