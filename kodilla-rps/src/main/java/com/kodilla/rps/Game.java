package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random generator = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final Battle battle = new Battle();
    private int roundScore;
    private int computerChoice;
    private int userChoice;

    private final int rounds;
    private int joker;
    private final int difficulty;

    public Game(int rounds, int joker, int difficulty) {
        this.rounds = rounds;
        this.joker = joker;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Ustawienia gry: " +
                "rund=" + rounds +
                ", jokerów=" + joker +
                ", trudność=" + difficulty;
    }

    public void playGame() {
        int generalScore = 0;
        boolean dataOK = false;
        String scannerInput;

        for(int i = 0; i < rounds; i++){
            while(!dataOK) {
                System.out.println("Wybierz ruch: 1-kamień, 2-papier, 3-nożyczki");
                scannerInput = scanner.nextLine();
                if(DataLoader.isNumeric(scannerInput)
                        && (Integer.parseInt(scannerInput) == 1
                            || Integer.parseInt(scannerInput) == 2
                            || Integer.parseInt(scannerInput) == 3)) {
                    userChoice = Integer.parseInt(scannerInput);
                }
                if( userChoice == 1 || userChoice == 2 || userChoice == 3) dataOK = true;
            }
            dataOK = false;
            System.out.println("Twój ruch to: " + Display.choice(userChoice));
            selectDifficulty();
            if(roundScore < 1 && joker > 0) {
                System.out.println("Masz " + joker + " joker. Chcesz użyć jokera?");
                System.out.println("t - tak, inny znak - nie");
                String jokerChoice = scanner.nextLine();
                if(jokerChoice.equals("t")) {
                    selectDifficulty();
                    joker--;
                }
            }
            generalScore += roundScore;
            Display.roundResult(roundScore);
        }
        Display.gameResult(generalScore);
    }

    private void selectDifficulty() {
        if (difficulty == 1) {
            computerChoice = (generator.nextInt(300) / 100) + 1;
        } else if (difficulty == 2) {
            computerChoice = battle.computerChoiceLevelHard(userChoice);
        }
        System.out.println("Komputera ruch to: " + Display.choice(computerChoice));
        roundScore = battle.isWon(userChoice, computerChoice);
    }
}
