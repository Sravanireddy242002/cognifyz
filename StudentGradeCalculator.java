import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        
        // Create an array to store the grades
        double[] grades = new double[numGrades];
        
        // Input the grades from the user
        double total = 0; // Variable to store the sum of the grades
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i]; // Add the grade to the total
        }
        
        // Calculate the average grade
        double average = total / numGrades;
        
        // Display the average grade to the user
        System.out.printf("The average grade is: %.2f\n", average);
        
        // Close the scanner object to prevent memory leaks
        scanner.close();
    }
}
