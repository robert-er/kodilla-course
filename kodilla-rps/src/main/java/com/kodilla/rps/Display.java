package com.kodilla.rps;

public class Display {
    public static String choice(int k) {
        if (k == 1) return "kamień";
        if (k == 2) return "papier";
        if (k == 3) return "nożyczki";
        return "";
    }

    public static void roundResult(int roundScore) {
        if (roundScore > 0) System.out.println("Wygrana!");
        if (roundScore == 0) System.out.println("Remis!");
        if (roundScore < 0) System.out.println("Przegrana :(");
    }

    public static void gameResult(int generalScore) {
        System.out.println("Końcowy wynik: " + generalScore);
        roundResult(generalScore);
    }
}
