import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JApplet;

public class GuessingGame extends JApplet implements ActionListener {
    private JTextField text = new JTextField(20);
    private static int randomNumber = new Random().nextInt(10);
    /**
     * Main method that is responsible for
     * creating an instance of the game
     * which is ran from the play method.
     * @param arg An array of String objects.
     */
    public static void main(String arg[]) {
        System.out.println(randomNumber);
        RevisedGuessingGame game = new RevisedGuessingGame();
        game.play();
    }

    /**
     * A method that is responsible for starting the game
     * (prompting the user).
     * You call this method by accessing the main.
     */
    public void play() {
        System.out.print("Guess a number (0-9) ");
        checkGuess(getGuess());
    }

    /**
     * This method is responsible for checking and gives
     * feedback if the user guess matches
     * the randomly generated number.
     * You call checkGuess method by playing the game
     * when the play method is ran.
     * @param guess An integer that the user is guessing.
     * @return isGuessed A boolean checking if number is guessed.
     */
    public boolean checkGuess(int guess) {
        boolean isGuessed = false;
        while (!isGuessed){
            if (randomNumber == guess) {
                System.out.println("You win!");
                isGuessed = true;
            } else if (randomNumber > guess) {
                System.out.println("Too low!");
                play();
            } else {
                System.out.println("Too high!");
                play();
            }
            return isGuessed;
        }
        return isGuessed;
    }

    /**
     * A method that is responsible for receiving
     * the integer guess and checking if its a valid number.
     * getGuess method is called when passing a parameter to
     * checkGuess method to receive the prompt the user guessed.
     * @return Returning an integer that the user entered.
     */
    public int getGuess() {
        Scanner input = new Scanner(System.in);
        int guess;
        while (true) {
            guess = input.nextInt();
            if (guess > 9 || guess < 0)
                System.out.println("Error!");
            else
                return guess;
        }
    }
    public void actionPerformed(ActionEvent e)   {
        Container contentPane = getContentPane();
        if (e.getActionCommand().equals("Sunny"))
            contentPane.setBackground(Color.BLUE);
        else if (e.getActionCommand().equals("Cloudy")){
            contentPane.setBackground(Color.GRAY);
        }
        else {
            System.out.println("Error in button inference.");
        }

    }

    @Override
    public void init() {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout());
        JButton sunnyButton = new JButton("Sunny");
        contentPane.add(sunnyButton);
        contentPane.add(text);
        sunnyButton.addActionListener(this);
        JButton cloudyButton = new JButton("Cloudy Button");
        contentPane.add(cloudyButton);
        cloudyButton.addActionListener(this);
    }
}
