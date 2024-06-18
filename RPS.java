package RPS;

import java.util.*;

public class RPS {

    public static void mainGame() {
        ArrayList<String> choices = new ArrayList<>(Arrays.asList("Rock", "Paper", "Scissors"));
        Random random = new Random();
        String botChoice = choices.get(random.nextInt(choices.size()));

        System.out.println("Bot chose: \n" +
                botChoice +
                "\nPlease remove once all bugs removed.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Welcome to Rock, Paper, Scissors!
                Choose the game mode you wish to play!
                (Input 1, 2, 3 or other numbers. Do not put decimals or characters.)
                1 Normal Mode
                2 Reversed Mode
                3 Low Odds Mode
                4 Exit
                """);

        for (int i = 0; i < 1; i++) {
            try {
                int selection = Integer.parseInt(scanner.next());

                if (selection == 1) {
                    System.out.println("""
                            Welcome to the normal mode!
                            The rules are the same as the traditional Rock, Paper, Scissors!
                            \nMake your choice!
                            Rock
                            Paper
                            Scissors
                            """);
                    Scanner scanner2 = new Scanner(System.in);

                    //make an if statement to check if the input is only either Rock Paper or Scissors.

                    for (int tries = 0; tries < 1; tries++) {
                        String playerChoice = scanner2.nextLine();
                        if (botChoice.equalsIgnoreCase(playerChoice)) {
                            System.out.println("It's a draw! try again!"); //draw if player and bot same choice
                            botChoice = choices.get(random.nextInt(choices.size()));
                            tries--;
                        } else if ((playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Scissors")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Paper"))) {
                            System.out.println("You won!"); //player wins bot
                            tries++;
                        } else if ((playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Paper")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Scissors"))) {
                            System.out.println("You lost!"); //player loses to bot
                            tries++;
                        } else /*if (!playerChoice.equalsIgnoreCase("Scissors") ||
                        !playerChoice.equalsIgnoreCase("Rock") ||
                        !playerChoice.equalsIgnoreCase("Paper")) */ {
                            System.out.println("Please input either Rock, Paper, or Scissors");
                            tries--;
                        }
                    }

                } else if (selection == 2) {
                    System.out.println("""
                            Welcome to the reversed mode!
                            The rules are reversed from the traditional Rock, Paper, Scissors!
                            \nMake your choice!
                            Rock
                            Paper
                            Scissors
                            """);

                    Scanner scanner2 = new Scanner(System.in);
                    for (int tries = 0; tries < 1; tries++) {
                        String playerChoice = scanner2.nextLine();
                        if (botChoice.equalsIgnoreCase(playerChoice)) {
                            System.out.println("It's a draw! try again!"); //draw if player and bot same choice
                            botChoice = choices.get(random.nextInt(choices.size()));
                            tries--;
                        } else if ((playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Scissors")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Paper"))) {
                            System.out.println("Bot wins!"); //player loses to bot
                        } else if ((playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Paper")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Scissors"))) {
                            System.out.println("You win!"); //player wins against bot
                        } else {
                            System.out.println("Please input either Rock, Paper, or Scissors");
                            tries--;
                        }
                    }

                } else if (selection == 3) {
                    System.out.println("""
                            Welcome to the low odds mode!\s
                            The rules are the same as traditional Rock, Paper, Scissors but draws are also considered as losses!
                            \nMake your choice!
                            Rock
                            Paper
                            Scissors
                            """);

                    Scanner scanner2 = new Scanner(System.in);

                    for (int tries = 0; tries < 1; tries++) {
                        String playerChoice = scanner2.nextLine();

                        if ((playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Scissors")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Paper"))) {
                            System.out.println("You win!"); //player loses to bot
                        } else if ((playerChoice.equalsIgnoreCase("Scissors") && botChoice.equalsIgnoreCase("Rock")) ||
                                (playerChoice.equalsIgnoreCase("Rock") && botChoice.equalsIgnoreCase("Paper")) ||
                                (playerChoice.equalsIgnoreCase("Paper") && botChoice.equalsIgnoreCase("Scissors")) ||
                                (playerChoice.equalsIgnoreCase(botChoice))) {
                            System.out.println("You lost!"); //player wins against bot
                        } else {
                            System.out.println("Please input either Rock, Paper, or Scissors");
                            tries--;
                        }
                    }
                } else System.out.print("Goodbye!");
            } catch (NumberFormatException ex) {
                System.out.println("Input is not recognized. ");
                i--;
            }
        }
    }

    public static void main (String[] args) {
        mainGame();
    }

}