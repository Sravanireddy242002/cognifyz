import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the temperature value
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        // Prompt the user to specify the unit (Celsius or Fahrenheit)
        System.out.print("Enter the unit of temperature (C for Celsius or F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);
        
        // Convert and display the result based on the input unit
        if (unit == 'C' || unit == 'c') {
            // Convert Celsius to Fahrenheit
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.printf("%.2f Celsius is %.2f Fahrenheit.\n", temperature, fahrenheit);
        } else if (unit == 'F' || unit == 'f') {
            // Convert Fahrenheit to Celsius
            double celsius = (temperature - 32) * 5/9;
            System.out.printf("%.2f Fahrenheit is %.2f Celsius.\n", temperature, celsius);
        } else {
            // Handle invalid unit input
            System.out.println("Invalid unit! Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
        
        // Close the scanner object to prevent memory leaks
        scanner.close();
    }
}
