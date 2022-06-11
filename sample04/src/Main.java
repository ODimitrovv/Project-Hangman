import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rnd = new Random();
        String[] wordArray = {"Razgrad", "Sliven", "Koprivshtica", "Sofiq", "Varna", "Burgas", "Ruse", "Vratsa",
                "Shumen", "Plovdiv", "Kavarna", "Botevgrad", "Blagoevo", "Silistra", "Borovec", "Getsovo", "Drqnovec",};
        String userGuess;
        int guessedLetters = 0;
        String wordChosen = wordArray[rnd.nextInt(15)];
        int lifePoints = 6;
        String noSpace = "";
        // ----------------------------------------------------------------------------------------
        // ARRAYS FOR UNDER DASHES!

        String[] underDashWord = new String[wordChosen.length()];
        String[] wordByLettersArray = new String[wordChosen.length()];

        //-----------------------------------------------------------------------------------------
        // Giving them the index values
        Arrays.fill(underDashWord, "_");
        for (int i = 0; i < wordChosen.length(); i++) {
            wordByLettersArray[i] = String.valueOf(wordChosen.charAt(i));
        }

        // ----------------------------------------------------------------------------------------
        // loop

        while (lifePoints != 0){
            System.out.print("Guess a letter: ");
            userGuess = String.valueOf(read.next().charAt(0));

            for (int i = 0; i < underDashWord.length; i++) {
                if (wordByLettersArray[i].equals(userGuess)){
                    underDashWord[i] = wordByLettersArray[i];
                }
            }
            if(wordChosen.contains(userGuess)){

                System.out.println("You guessed a letter");
                guessedLetters++;
                if(guessedLetters == wordChosen.length()-1){
                    System.out.println("You guessed the word! Good job! \nWord was: " + wordChosen);
                    System.exit(0);
                }
            }
            // Drawing the hanging thing
            else{
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