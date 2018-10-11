package org.computermentors.NyjelDukes;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
        Prompter prompter = new Prompter(game);

        while (game.getTriesRemaining() > 0 && !game.isWon()){
            prompter.displayProgress();
            prompter.promptForGuess();
        }

        prompter.displayOutcome();
    }
}
