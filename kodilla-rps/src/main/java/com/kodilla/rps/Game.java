package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random generator = new Random();
    private final Scanner scanner = new Scanner(System.in);
    Battle battle = new Battle();

    public void playGame(User user) {
        int generalScore = 0;
        int computerChoice = 0;
        int userChoice = 0;
        for(int i = 0; i < user.getRounds(); i++){
            int roundScore = 0;
            System.out.println("Wybierz ruch: 1-kamień, 2-papier, 3-nożyczki");
            userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println("Twój ruch to: " + Display.choice(userChoice));
            if (user.getDifficulty() == 1) {
                computerChoice = (generator.nextInt(300) / 100) + 1;
            } else if (user.getDifficulty() == 2) {
                computerChoice = battle.computerChoiceLevelHard(userChoice);
            }
            System.out.println("Komputera ruch to: " + Display.choice(computerChoice));
            roundScore = battle.isWon(userChoice, computerChoice);
            if (roundScore < 1 && user.getJoker() > 0) {
                System.out.println("Masz " + user.getJoker() + " joker. Chcesz użyć jokera?");
                System.out.println("t - tak, inny znak - nie");
                String jokerChoice = scanner.nextLine();
                if (jokerChoice.equals("t")) {
                    if (user.getDifficulty() == 1) {
                        computerChoice = (generator.nextInt(300) / 100) + 1;
                    } else if (user.getDifficulty() == 2) {
                        computerChoice = battle.computerChoiceLevelHard(userChoice);
                    }
                    System.out.println("Komputera ruch to: " + Display.choice(computerChoice));
                    roundScore = battle.isWon(userChoice, computerChoice);
                    user.setJoker(user.getJoker()-1);
                }
            }
            generalScore += roundScore;
            Display.roundResult(roundScore);
        }
        Display.gameResult(generalScore);
    }
}
