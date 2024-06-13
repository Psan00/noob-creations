package NumberGame;

import java.util.Scanner;

public class NumberGame {

    public static void numberGuessing() {
        Scanner sc = new Scanner(System.in);

        //generate the number to be guessed, 1-100;
        int number = (int) (100*Math.random()) + 1;

        //number of tries/guesses:
        int K = 5;
        int guess, i;

        System.out.println("A number was randomly chosen," +
                           " between 1 to 100." +
                           " Guess within 5 tries to win.");

        System.out.println("Guess the number: ");

        //Iterates the loop over number of tries:
        for (i = 0; i < K; i++) {
            String input1 = sc.nextLine();
            /*validating if guess is an int*/
            if (!isInt(input1)) /*if input1 is true (an int)*/ {
                i--;
                System.out.println("Please only input a number between 1 to 100.");
            } else {
                /* makes the input1 an int and makes it into guess.
                else, making guess = sc.nextInt() creates a double input every guess*/
                guess = Integer.parseInt(input1);
                //if not between 1 - 100, try again
                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number between 1 to 100. ");
                    i--;
                }
                /* self-explanatory */
                else if (guess == number) {
                    System.out.println("Congratulations! You've got it right! The number was" + number);
                    break;
                } else if ((guess > number) && (i != K - 1)) /* remember you start i from 0 */ {
                    System.out.println("The number is lower than " + guess + ". Try again:");
                } else if ((guess < number) && (i != K - 1)) {
                    System.out.println("The number is higher than " + guess + ". Try again:");
                }
            }
        }

        /* lose condition */
        if (i == K) {
            System.out.println("You lose. The number was " + number);
            System.out.println("Try again!");
        }

    }

    /* this is a mini checker to see if the input is an int or not */
    public static boolean isInt(String checker) {

        try {
            Integer.parseInt(checker);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static void main (String[] args) {
        numberGuessing();
    }

}

/* Notes:
Existing bugs:
1. Cannot refuse a non-numbered guess. if Loop at 30 causes an infinite loop. Find out how to resolve this.
    Likely because hasNextInt() takes in the next input. if the input doesn't exist, then the loop is infinite.

    1.1:
    this has been fixed by implementing another method to verify the user's input.
    but now the issue is how to return to the original loop of accepting the user's input and verifying
    if the input is an int or not.

    1.2:
    fixed i guess? somehow shifting the String input1 = sc.nextLine(); to within for loop fixed the issue.
    using if loop on isInt method on line 30 worked for some reason.
*/