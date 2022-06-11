import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void rewriteDashArray(String[] dashes, String[] letters, String guess){
        for (int i = 0; i < dashes.length; i++) {
            if (letters[i].equals(guess)){
                dashes[i] = letters[i];
            }
        }
    }
    public static boolean checkRepeatedGuess(String[] dashArray, String guess){
        for (int i = 0; i < dashArray.length; i++) {
            if (dashArray[i].equals(guess)){
                return false;
            }
        }

        return true;
    }
    public static int pointsNeeded(String[] wordByLetters){
        int points = 0;
        // TODO: fix words with a letter that is repeated more then once
        for (int i = 0; i < wordByLetters.length; i++) {
            for (int j = i + 1; j < wordByLetters.length; j++) {
                if(wordByLetters[i].equals(wordByLetters[j])){
                    points--;
                }
            }
            points++;
        }

        return points;
    }
    // TODO: make the dashes array and the word by letters array get their values trough a method
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rnd = new Random();
        String[] wordArray = {"Razgrad", "Sliven", "Koprivshtica", "Sofiq", "Varna", "Burgas", "Ruse", "Vratsa",
                "Shumen", "Plovdiv", "Kavarna", "Botevgrad", "Blagoevo", "Silistra", "Borovets", "Getsovo", "Drqnovets"};
        String wordChosen = wordArray[rnd.nextInt(15)];
        // ARRAYS FOR UNDER DASHES!

        String[] underDashWord = new String[wordChosen.length()];
        String[] wordByLettersArray = new String[wordChosen.length()];

        // Giving the arrays above values depending on the word`s length
        Arrays.fill(underDashWord, "_");
        for (int i = 0; i < wordChosen.length(); i++) {
            wordByLettersArray[i] = String.valueOf(wordChosen.charAt(i));
        }

        // Checking how many players will be playing.
        System.out.print("""
                How many players will be playing?
                ---------------------------------\s
                 1. One Player\s
                 2. Two Players\s
                ---------------------------------\s
                >>>""");
        int playerCount = read.nextInt();

        String noSpace = "";
        switch (playerCount){
            case 1:

                String userGuess;
                int guessedLetters = 0;
                int lifePoints = 6;

                while (lifePoints != 0){
                    System.out.print("Guess a letter: ");
                    userGuess = String.valueOf(read.next().charAt(0));

                    if(wordChosen.contains(userGuess) && checkRepeatedGuess(underDashWord, userGuess)){
                        System.out.println("You guessed a letter");
                        guessedLetters++;

                        // Updates underDashWord array
                        rewriteDashArray(underDashWord, wordByLettersArray, userGuess);

                        // Checks if the word has been guessed
                        if(guessedLetters == pointsNeeded(wordByLettersArray)){
                            System.out.println("You guessed the word! Good job! \nWord was: " + wordChosen);
                            System.exit(0);
                        }
                    } else{ // Drawing the hangman picture
                        lifePoints--;
                        if(lifePoints == 5){

                            System.out.println("""
                             /-----|
                             |
                             |
                             |
                             |
                             |
                             |
                             /\\""");
                        }else if(lifePoints == 4){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |
                             |
                             |
                             |
                             /\\""");
                        }else if (lifePoints == 3){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |     /\\
                             |    /  \\
                             |
                             |
                             /\\""");
                        } else if (lifePoints == 2) {
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |    /|\\
                             |   / | \\
                             |
                             |
                             /\\""");
                        }else if(lifePoints == 1){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             | ---/|\\---
                             |   / | \\
                             |   |---|
                             |  _|   |_
                             /\\""");
                        }

                    }
                    System.out.println(String.join(noSpace, underDashWord));
                }
                // if we have lost the loop stops since our hp got to 0 and this is what comes next:
                System.out.println("------------------------------------");
                System.out.println("You lose...\nWord was: "+ wordChosen + "      | DEAD |");
                System.out.println("------------------------------------");
                break;
            case 2:
                // TODO: Check which player is guessing to see who guessed the word last
                // TODO: Add scores
                String userGuessTwoPlayers;
                int guessedLettersTwoPlayers = 0;
                int lifePointsTwoPlayers = 6;
                System.out.println("Player one starts first.");

                while (lifePointsTwoPlayers != -1){
                    System.out.print("Guess a letter: ");
                    userGuessTwoPlayers = read.next();
                    if (wordChosen.contains(userGuessTwoPlayers) && checkRepeatedGuess(underDashWord, userGuessTwoPlayers)){
                        System.out.println("You guessed a letter");
                        guessedLettersTwoPlayers++;

                        // Updates underDashWord array
                        rewriteDashArray(underDashWord, wordByLettersArray, userGuessTwoPlayers);

                        // Checks if the word has been guessed
                        if(guessedLettersTwoPlayers == pointsNeeded(wordByLettersArray)){
                            System.out.println("You guessed the word! Good job! \nWord was: " + wordChosen);
                            System.exit(0);
                        }
                    } else{ // Drawing the hangman picture
                        lifePointsTwoPlayers--;
                        if(lifePointsTwoPlayers == 5){

                            System.out.println("""
                             /-----|
                             |
                             |
                             |
                             |
                             |
                             |
                             /\\""");
                        }else if(lifePointsTwoPlayers == 4){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |
                             |
                             |
                             |
                             /\\""");
                        }else if (lifePointsTwoPlayers == 3){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |     /\\
                             |    /  \\
                             |
                             |
                             /\\""");
                        } else if (lifePointsTwoPlayers == 2) {
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             |    /|\\
                             |   / | \\
                             |
                             |
                             /\\""");
                        }else if(lifePointsTwoPlayers == 1){
                            System.out.println("""
                             /-----|
                             |   / - \\
                             |    o o
                             |   \\ - /
                             | ---/|\\---
                             |   / | \\
                             |   |---|
                             |  _|   |_
                             /\\""");
                        }
                    }
                    System.out.println(String.join(noSpace, underDashWord));
                    if(lifePointsTwoPlayers == 0){
                        System.out.println("Do you wish to play again?");
                        String doYouContinue = read.next();
                        if (doYouContinue.equals("yes")){
                            lifePointsTwoPlayers += 6;
                        }
                    }
                }
                break;
            default:
                System.out.println("ERROR! MAX 2 PLAYERS!");
                break;
        }
    }
}