package io.vividcode.graalvm.initialization;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {

    private static final int target = ThreadLocalRandom.current().nextInt(100);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("A number is required!");
            return;
        }
        try {
            int guess = Integer.parseInt(args[0]);
            if (guess > target) {
                System.out.println("Too big!");
            } else if (guess < target) {
                System.out.println("Too small!");
            } else {
                System.out.println("You win!");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number input!");
        }
    }
}
