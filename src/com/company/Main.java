package com.company;

public class Main {

    private static final String[][] players = new String[][]{{"Gay", "5"}, {"Gay", "5"}, {"Gay", "5"}, {"Lox", "6"}, {"Lesbian", "3"}, {"Daddy", "1"},};

    public static void main(String[] args) {

        findThreeTheBest(players);
    }

    public static void findThreeTheBest(String[][] players) {
        int result = findMax(players);


        for (int i = 0; i <= 3; i++) {
            String[] playersNames = findPlayerByScore(players, result);
            printIntoConsole(playersNames);
            result = findMaxLessThan(players, result);
        }
    }

    public static void printIntoConsole(String[] playersNames) {

        for (String name : playersNames) {
            if (name != null) {
                System.out.println(name + "\n");
            }
        }
    }

    public static String[] findPlayerByScore(String[][] players, int score) {
        String[] winers = new String[players.length];
        int counterSize = 0;
        for (String[] player : players) {
            if (player[1].equals(String.valueOf(score))) {
                winers[counterSize] = player[0];
                counterSize++;
            }
        }
        return winers;
    }

    public static int findMax(String[][] players) {
        int max = Integer.parseInt(players[0][1]);

        for (String[] player : players) {
            if (max < Integer.parseInt(player[1])) {
                max = Integer.parseInt(player[1]);
            }
        }
        return max;
    }

    public static int findMaxLessThan(String[][] players, int value) {
        int max = value - 1;

        for (String[] player : players) {
            if (max < Integer.parseInt(player[1]) && max > value) {
                max = Integer.parseInt(player[1]);
            }
        }
        return max;
    }
}
