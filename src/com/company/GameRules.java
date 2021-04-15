package com.company;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameRules {

    public int getComputerMove(String[] args) {
        return new Random().nextInt(args.length)+1;
    }

    public int receiveMove(String[] args) {
        System.out.println("Enter your move: ");
        Scanner scan = new Scanner(System.in);
        int userMove;
        try {
            userMove = scan.nextInt();
            if (userMove > args.length || userMove < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ie) {
            System.out.println("Incorrect choice. Try again\n");
            userMove = receiveMove(args);
        }
        return userMove;
    }

    public String determineWinner(String[] args, int userMove, int pcMove) {
        int sub = Math.abs(pcMove - userMove);
        int countOfOptions = (args.length - 1) / 2;
            if (pcMove == userMove) {
                return "No";
            } else if (pcMove > userMove && countOfOptions >= sub || pcMove < userMove && countOfOptions < sub) {
                return "PC is ";
            } else {
                return "You are ";
            }
    }
}
