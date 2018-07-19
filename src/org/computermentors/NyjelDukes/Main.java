package org.computermentors.NyjelDukes;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game("onepiece");
        Prompter prompter = new Prompter(game);

        while (game.getTriesRemaining() > 0){
            prompter.displayProgress();
            prompter.promptForGuess();
        }
    }
}
