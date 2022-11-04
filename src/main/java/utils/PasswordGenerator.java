package utils;

import configurations.Configuration;
import java.security.SecureRandom;

public class PasswordGenerator {

    private static int resultSize = 25;
    private static int generatorSize = 5;
    private static String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseAlphabet = "ABCDEFGHIJKLMNOPRQRSTUVWXYZ";
    private static String digit = "0123456789";
    private static SecureRandom random = new SecureRandom();

    public static String generatePassword() {
        StringBuilder resultString = new StringBuilder(resultSize);
        String lowerCase = generateRandomString(lowerCaseAlphabet);
        resultString.append(lowerCase);
        String upperCase = generateRandomString(upperCaseAlphabet);
        resultString.append(upperCase);
        String digits = generateRandomString(digit);
        resultString.append(digits);

        resultString.append(Configuration.getEmail());

        return resultString.toString();
    }

    private static String generateRandomString(String input) {

        if ( generatorSize < 1 || input == null || input.length() <= 0) {
            throw new IllegalArgumentException("Please check the input information");
        }

        StringBuilder resultString = new StringBuilder(generatorSize);

        for (int i = 0; i < generatorSize; i++) {
            int index = random.nextInt(input.length());
            resultString.append(input.charAt(index));
        }
        return resultString.toString();
    }
}

