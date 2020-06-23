package com.kodilla.rps;

import java.util.*;

public class Battle {
    private final static int ROCK = 1;
    private final static int PAPER = 2;
    private final static int SCISSORS = 3;
    private final static int COMPUTER_CHOICE_LIST_QUARTER_SIZE = 25;

    public int isWon(int userChoice, int computerChoice) {
        //   int[userMove][computerMove]
        int[][] winningDiagram = new int[3][3];
        // result is 1=win , 0=draw, -1=loose
        winningDiagram[0][0] = 0;
        winningDiagram[0][1] = -1;
        winningDiagram[0][2] = 1;
        winningDiagram[1][0] = 1;
        winningDiagram[1][1] = 0;
        winningDiagram[1][2] = -1;
        winningDiagram[2][0] = -1;
        winningDiagram[2][1] = 1;
        winningDiagram[2][2] = 0;
        return winningDiagram[userChoice-1][computerChoice-1];
    }

    public int computerChoiceLevelHard(int userChoice) {
        List<Integer> answerList = new ArrayList<>();
        final Random generator = new Random();
        int won50percent = 0;
        int loose25percent = 0;
        int draw25percent = 0;

        if (userChoice == ROCK) {
            won50percent = PAPER;
            loose25percent = SCISSORS;
            draw25percent = ROCK;
        }
        if (userChoice == PAPER) {
            won50percent = SCISSORS;
            loose25percent = ROCK;
            draw25percent = PAPER;
        }
        if (userChoice == SCISSORS) {
            won50percent = ROCK;
            loose25percent = PAPER;
            draw25percent = SCISSORS;
        }
        for(int i = 0; i <COMPUTER_CHOICE_LIST_QUARTER_SIZE; i++) {
            answerList.add(loose25percent);
            answerList.add(won50percent);
            answerList.add(draw25percent);
            answerList.add(won50percent);
        }
        Collections.shuffle(answerList);
        return answerList.get(generator.nextInt(answerList.size()));
    }
}
