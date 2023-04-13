import java.util.Random;
import java.io.*;

// This program should first generate 4 capital letter string and then attempt to find that string via brute force.
// The program then does this with a 4 character string containing all letters, numbers, and special characters.
// The program should output it's results to a file called PasswordCrackerOutput.txt
public class PasswordCracker {
    public static void main(String[] args) throws IOException{
        // Introduction
        FileWriter writer = new FileWriter("PasswordCrackerOutput.txt");
        System.out.println("04/11/2023 Assignment #7 for ICS 462 by Freddy Valle\n");
        writer.write("04/11/2023 Assignment #7 for ICS 462 by Freddy Valle\n");

        // Round 1, this is the generated password with 4 randomized uppercase letters.
        String targetString = generateRandomLetters();
        System.out.println("Generated password is: " + targetString);
        System.out.println("Generated password in hex is: " + stringToHex(targetString));
        writer.write("\nGenerated password is: " + targetString);
        writer.write("\nGenerated password in hex is: " + stringToHex(targetString));
        String guessString = "";
        Random rand = new Random();
        int tries = 0;
        long startTime = System.currentTimeMillis();
        while (!guessString.equals(targetString)) {
            char c1 = (char) (rand.nextInt(26) + 'A');
            char c2 = (char) (rand.nextInt(26) + 'A');
            char c3 = (char) (rand.nextInt(26) + 'A');
            char c4 = (char) (rand.nextInt(26) + 'A');
            guessString = "" + c1 + c2 + c3 + c4;
            tries++;
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Found the password after " + tries + " guesses.");   
        System.out.println("It took " + totalTime/1000.0 + " seconds to find the password. \n");
        writer.write("\nFound the password after " + tries + " guesses.");
        writer.write("\nIt took " + totalTime/1000.0 + " seconds to find the password. \n");

        // Round 2, this is the random string with numbers, characters and all.
        targetString = generateRandomString();
        System.out.println("Generated password is: " + targetString);
        System.out.println("Generated password in hex is: " + stringToHex(targetString));
        writer.write("\nGenerated password is: " + targetString);
        writer.write("\nGenerated password in hex is: " + stringToHex(targetString));
        guessString = "";
        startTime = System.currentTimeMillis();
        tries = 0;
        while (!guessString.equals(targetString)) {
            guessString = generateRandomString();
            tries++;
        }
        endTime = System.currentTimeMillis();
        long totalTime2 = endTime - startTime;
        System.out.println("Found the password after " + tries + " guesses.");
        System.out.println("It took " + totalTime2/1000.0 + " seconds to find the password. \n");
        writer.write("\nFound the password after " + tries + " guesses."); 
        writer.write("\nIt took " + totalTime2/1000.0 + " seconds to find the password. \n");
        
        System.out.println("It took " + (double)totalTime2/totalTime + " times as long with the expanded character set to guess the password.");
        writer.write("\nIt took " + (double)totalTime2/totalTime + " times as long with the expanded character set to guess the password.");
        writer.close();
    }

    // Helper method to convert a string to Hexadecimal
    public static String stringToHex(String inputString) {
        StringBuilder hex = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            hex.append(Integer.toHexString((int) c));
        }
        return hex.toString();
    }

    // Helper method to generate a string with 4 random capital letters.
    public static String generateRandomLetters() {
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char c = (char) (rand.nextInt(26) + 'A');
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    // Helper method to generate a string with 4 random letters, numbers and special characters.
    public static String generateRandomString() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789:;><=?@{}\\^_`";
        int length = 4;
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            char c = characters.charAt(index);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}