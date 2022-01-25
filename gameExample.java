//Joshua Furman, CS1400 Homework #3

import java.util.Scanner;
import java.io.*;
import java.lang.Math.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean looper = true;
        int gameEnd = 0;
        System.out.println("Welcome to Nim!");
        System.out.println("Please input your number between 10-100: ");
        Scanner keyboard = new Scanner(System.in);
        int count = keyboard.nextInt(); //user inputs the guess

        if (count < 10 || count > 100) { //conditions not met, this will run
            System.out.println("You must enter a value between 10-100! I'm stopping the game.");
            System.exit(0);
        }
        System.out.println("You will now take turns as two players take as many as half of the marbles from the stack.");
        while (looper == true) {
            if (count == 2 || count == 1) {
                System.out.println("Ohhhh so sorry to player two (computer), just take the one marble. :(");
                looper = false;
                break;
            }
            int halfCount = count / 2;
            System.out.println("\033[0;32m" + "Player one is up. Your value is " + count);
            System.out.println("\033[0;30m" + " Please pick a value between 1 and " + halfCount + ".");

            int p1 = keyboard.nextInt(); //Player one guess
            if (p1 >= 1 && p1 <= halfCount) {
                count = count - p1; //changing of count from player one guess
            } else {
                System.out.println("You did not enter a value between 1 and " + halfCount + ".");
                continue;
            }
            if (count == 2 || count == 1) {
                System.out.println("Ohhhh so sorry to you, player. You just lost to a computer. Just take the one marble. :(");
                gameEnd = 1;
                looper = false;
                break;
            }
            halfCount = count / 2;  //to allow the computer to have a more tight half count and it's not just the human player
            System.out.println("\033[0;32m" + "Player two (computer) is up. Your value is " + count);
            System.out.println("\033[0;30m" + " Please pick a value between 1 and " + halfCount + ".");
            System.out.println(); //just because the terminal looks jumbled
            Random random = new Random();
            int computerGuess = random.nextInt(halfCount) + 1; //computers random guess between
            if (computerGuess >= 1 && computerGuess <= halfCount) {
                System.out.println("The computer has inputted " + computerGuess + ".");
                count = count - computerGuess; //changing of count from player two guess
            } else {
                System.out.println("You did not enter a value between 1 and " + halfCount + "." + "You entered: " + computerGuess);
            }

        }
        if (gameEnd == 1) {
            System.out.println("\033[0;36m" + "Player 2 (Computer) Wins!");
            System.out.println();
            System.out.println("Thank you for playing the game!");
        } else {
            System.out.println("\033[0;35m" + "Player 1 Wins!");
            System.out.println();
            System.out.println("Thank you for playing the game!");
        }
    }
}


