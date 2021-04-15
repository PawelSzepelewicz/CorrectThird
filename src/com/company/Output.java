package com.company;
import java.security.SecureRandom;

import static com.company.SecureCode.getHex;

public class Output {
    public static void playGame(String[] args) {
        GameRules game = new GameRules();

        byte[] secureCode = new byte[128];
        new SecureRandom().nextBytes(secureCode);
        String firstHMAC = getHex(secureCode);

        int pcMove = game.getComputerMove(args);
        String pcMoveHMAC = getHex(firstHMAC + args[pcMove-1]);
        System.out.println("HMAC + PC move: " + pcMoveHMAC.toUpperCase());
        showListOfMoves(args);
        int userMove = game.receiveMove(args);
        if(userMove==0){System.out.println("You left the game");
        } else{
        String winner = game.determineWinner(args, userMove, pcMove);
        showResultOfGame(args, winner, userMove, pcMove);
        System.out.println("HMAC: " + firstHMAC.toUpperCase());
        }
    }
    private static void showListOfMoves(String[] args) {
        System.out.println("Player, please make a move. " +
                "Point your choice by entering one of the options below:");
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + " - " + args[i]);
        } System.out.println("0 - exit");
    }

    private static void showResultOfGame(String[] args, String winner, int userMove, int pcMove) {
        System.out.printf("Your move is: %s\nPC move is: %s\n%s winner\n", args[userMove - 1], args[pcMove - 1], winner);
    }
}


