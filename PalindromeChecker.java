import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a word or phrase
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();
        
        // Remove spaces and non-alphanumeric characters, and convert to lowercase
        String sanitizedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the sanitized input is a palindrome
        if (isPalindrome(sanitizedInput)) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
        
        // Close the scanner object to prevent memory leaks
        scanner.close();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        
        return true; // It's a palindrome
    }
}
