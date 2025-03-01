import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Analyze the password strength
        String strength = checkPasswordStrength(password);

        // Display the result
        System.out.println("Password Strength: " + strength);
        
        scanner.close();
    }

    // Method to check the strength of the password
    public static String checkPasswordStrength(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean isLengthValid = password.length() >= 8; // Password should be at least 8 characters long

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            // Check for uppercase letters
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            // Check for lowercase letters
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }
            // Check for digits
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            // Check for special characters
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Determine password strength based on criteria
        if (isLengthValid && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (isLengthValid && ((hasUppercase && hasLowercase) || (hasDigit && hasSpecialChar))) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
