package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        String name;
        int rounds;
        int joker;
        int difficulty;
        String menu;
        Game game = new Game();

        while(!end) {
            System.out.println("Witemy w grze RPS");
            System.out.println(" n - nowa gra, x - wyjście z gry");
            menu = scanner.nextLine();

            switch (menu) {
                case "n" :
                    System.out.println("Podaj imie: ");
                    name = scanner.nextLine();
                    System.out.println("Podaj ilość rund: ");
                    rounds = Integer.parseInt(scanner.nextLine());
                    System.out.println("Joker umożliwia powtórne rozegranie rundy. Podaj ilość jokerów: ");
                    joker = Integer.parseInt(scanner.nextLine());
                    System.out.println("Wybierz trudność: 1 - normal, 2 - hard");
                    difficulty = Integer.parseInt(scanner.nextLine());
                    User user = new User(name, rounds, joker, difficulty);
                    System.out.println(user);
                    game.playGame(user);
                    break;
                case "x" :
                    end = true;
                    break;
            }
        }
    }
}
