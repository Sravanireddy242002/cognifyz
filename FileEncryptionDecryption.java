import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    // Method for Caesar Cipher Encryption
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        // Loop through each character in the text
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = (Character.isUpperCase(character)) ? 'A' : 'a';
                result.append((char) ((character - base + shift) % 26 + base));
            } else {
                // Non-alphabet characters remain unchanged
                result.append(character);
            }
        }
        return result.toString();
    }

    // Method for Caesar Cipher Decryption
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);  // Decrypting is just reversing the shift
    }

    // Method to process the file (encrypt or decrypt)
    public static void processFile(String filePath, String operation, int shift) {
        try {
            // Reading the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            reader.close();
            
            // Encrypt or decrypt based on the user's choice
            String processedContent;
            if (operation.equals("encrypt")) {
                processedContent = encrypt(fileContent.toString(), shift);
            } else if (operation.equals("decrypt")) {
                processedContent = decrypt(fileContent.toString(), shift);
            } else {
                throw new IllegalArgumentException("Invalid operation. Choose 'encrypt' or 'decrypt'.");
            }

            // Save the result to a new file
            String newFilePath = filePath + "_" + operation + "_shift_" + shift + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
            writer.write(processedContent);
            writer.close();

            System.out.println("File successfully " + operation + "ed and saved as " + newFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + filePath + " does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading/writing the file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the File Encryption/Decryption Program!");

        // Input operation choice
        System.out.print("Choose operation (encrypt/decrypt): ");
        String operation = scanner.nextLine().toLowerCase();

        // Input file path
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Input shift value
        System.out.print("Enter the shift value (integer): ");
        int shift = scanner.nextInt();

        // Process the file based on user inputs
        processFile(filePath, operation, shift);

        // Close the scanner
        scanner.close();
    }
}
