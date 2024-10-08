import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGame {

    //instantiate all ui components first
    JFrame frame = new JFrame("Number Guessing Game");
    JTextField inputTextField = new JTextField();
    JButton[] functionButtons = new JButton[2];
    JButton cnfmButton, quitButton;
    JLabel mainScreenLabel = new JLabel("Guess a number from 1 - 100!");
    Font myFont = new Font("Arial", Font.BOLD, 15); //if you want to make it bold & italic, use the + sign and add Font.ITALIC after the +

    //how the game runs
    Random random = new Random();
    int answer = random.nextInt(0,100) + 1, guess; //answer is between 1 - 100 and instantiate the guess variable

    //core of how the game runs
    NumberGame() {

        //frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        mainScreenLabel.setBounds(0, 0, 400, 150);
        mainScreenLabel.setFont(myFont);
        mainScreenLabel.setHorizontalAlignment(SwingConstants.CENTER); //alights text to the center

        inputTextField.setBounds(150, 125, 100, 25);
        inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputTextField.setFont(myFont);

        //validate inputs made by user:
        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String value = inputTextField.getText();
                int i = value.length();
                inputTextField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b');
            }
        });


        //make and show buttons
        functionButtons[0] = cnfmButton;
        functionButtons[1] = quitButton;
        cnfmButton = new JButton("Confirm");
        cnfmButton.setBounds(100, 200, 100 ,30);
        cnfmButton.setFont(myFont);
        quitButton = new JButton("Quit");
        quitButton.setBounds(200, 200, 100, 30);
        quitButton.setFont(myFont);

        //make cnfmButton accept the input. if correct, show text, pass. if fail, retry and show text.
        cnfmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess = Integer.parseInt(inputTextField.getText()); //maybe add a catch here and show an "error" when submitting empty field.
                if (answer == guess) {
                    System.out.println("Correct!\n");
                    String [] options = {"Yes", "No"};
                    var selection = JOptionPane.showOptionDialog(null,"Correct! A new game will now restart! " +
                            "Do you want to continue?", "New game?", 0, 1, null, options, options[0]);

                    if (selection == 1) {
                        JOptionPane.showMessageDialog(null, "See you again, bye!", "Bye!", JOptionPane.INFORMATION_MESSAGE); System.exit(0);
                    } else {
                        answer = random.nextInt(0,100) + 1;
                        System.out.println(answer);
                    }

                } else JOptionPane.showMessageDialog(null, "Incorrect, try again!");

                inputTextField.setText("");

            }
        });

        //make quit button actually quit
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "See you again, bye!", "Bye!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        //makes everything added into the frame, and be visible
        frame.add(mainScreenLabel);
        frame.add(inputTextField);
        frame.add(cnfmButton);
        frame.add(quitButton);
        frame.setVisible(true);

        System.out.println("REMEMBER TO REMOVE AT THE END OF DEBUGGING\n" + answer);

    }

    public static void main(String[] args) {

        NumberGame launch = new NumberGame();

    }

}
