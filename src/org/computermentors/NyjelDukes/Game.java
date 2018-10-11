package org.computermentors.NyjelDukes;

import java.util.Random;

public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(){
        answer = getWord();
        hits = "";
        misses = "";
    }

    public String getAnswer() {
        return answer;
    }

    private char normilaizeGuess(char letter){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required...");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already been guessed...");
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normilaizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit){
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public boolean applyGuess(String letter){
        if (letter.length() == 0){
            throw new IllegalArgumentException("Enter a guess");
        }
        return applyGuess(letter.charAt(0));
    }

    public int getTriesRemaining() {
        return MAX_MISSES - misses.length();
    }

    public String getCurrentProgress(){
        String progress = "";
        for(char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon(){
        return getCurrentProgress().indexOf('-') == -1;
    }

    private String getWord(){
        String[] wordList = {
                "msmarvel",
                "spiderman",
                "nova",
                "hulk",
                "vision",
                "ironheart",
                "brawn"
        };

        Random random = new Random();

        return wordList[random.nextInt(wordList.length)];
    }
}
