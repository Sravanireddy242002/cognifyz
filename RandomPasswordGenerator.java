import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        // Ask the user which character types to include in the password
        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();
        
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();
        
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();
        
        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialCharacters = scanner.nextBoolean();
        
        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);
        
        // Display the generated password
        System.out.println("Generated password: " + password);
        
        // Close the scanner object to prevent memory leaks
        scanner.close();
    }

    // Method to generate the password
    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialCharacters) {
        // Define possible character sets for each type
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        // Combine all possible characters based on user input
        StringBuilder availableCharacters = new StringBuilder();
        if (includeNumbers) availableCharacters.append(numbers);
        if (includeLowercase) availableCharacters.append(lowercase);
        if (includeUppercase) availableCharacters.append(uppercase);
        if (includeSpecialCharacters) availableCharacters.append(specialCharacters);

        // If no character types are selected, return an error message
        if (availableCharacters.length() == 0) {
            return "Error: You must select at least one character type!";
        }

        // Create a Random object to select random characters
        Random random = new Random();

        // Generate the password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(availableCharacters.length());
            password.append(availableCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}
