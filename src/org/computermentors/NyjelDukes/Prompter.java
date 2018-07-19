package org.computermentors.NyjelDukes;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game){
        this.game = game;
    }

    public boolean promptForGuess(){
        System.out.print("Enter a letter:  ");
        Scanner scanner = new Scanner(System.in);
        String guessInput = scanner.nextLine();
        char guess = guessInput.charAt(0);
        return game.applyGuess(guess);
    }

    public void displayProgress(){
        System.out.printf("You %d tries left ot solve %s %n",
                game.getTriesRemaining(), game.getCurrentProgress());
    }
}
