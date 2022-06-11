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

        String userGuess;
        int guessedLetters = 0;
        int lifePoints = 6;
        String noSpace = "";

        while (lifePoints != 0){
            System.out.print("Guess a letter: ");
            userGuess = String.valueOf(read.next().charAt(0));

            if(wordChosen.contains(userGuess) && checkRepeatedGuess(underDashWord, userGuess)){
                System.out.println("You guessed a letter");
                guessedLetters++;

                // Updates underDashWord array
                rewriteDashArray(underDashWord, wordByLettersArray, userGuess);

                // Checks if the word has been guessed
                if(guessedLetters == wordChosen.length()-1){
                    System.out.println("You guessed the word! Good job! \nWord was: " + wordChosen);
                    System.exit(0);
                }
            } else{ // Drawing the hangman picture
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
                lifePoints--;
            }
            System.out.println(String.join(noSpace, underDashWord));
        }
        // if we have lost the loop stops since our hp got to 0 and this is what comes next:
        System.out.println("------------------------------------");
        System.out.println("You lose... \nWord was: "+ wordChosen);
        System.out.println("------------------------------------");

    }
}