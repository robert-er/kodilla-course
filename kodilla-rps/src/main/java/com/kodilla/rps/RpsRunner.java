package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        String menu = "";
        boolean dataOK = false;
        String scannerInput;
        while(!end) {
            System.out.println("Witemy w grze RPS");
            while(!dataOK) {
                System.out.println(" n - nowa gra, x - wyjście z gry");
                scannerInput = scanner.nextLine();
                if(scannerInput.equals("n") || scannerInput.equals("x")) {
                    menu = scannerInput;
                    dataOK = true;
                }
            }
            dataOK = false;
            switch (menu) {
                case "n" :
                    DataLoader dataLoader = new DataLoader();
                    User user = dataLoader.getUserData();
                    Game game = dataLoader.getGameData();
                    System.out.println(user);
                    System.out.println(game);
                    game.playGame();
                    break;
                case "x" :
                    end = true;
                    break;
            }
        }
    }
}
