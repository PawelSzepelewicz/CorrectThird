package com.company;
import java.util.Arrays;
import java.util.HashSet;
import static com.company.Output.playGame;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length % 2 == 0 ||
                    args.length <= 1 ) {
                throw new Exception("Incorrect arguments count");
            }
            if(args.length != new HashSet<>(Arrays.asList(args)).size()){
                throw new Exception("Same options");
            }
            playGame(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
