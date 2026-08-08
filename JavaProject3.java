package javaBro;

import java.util.Scanner;

public class JavaProject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight;
        double newWeight;
        double heightCm;
        double feet;
        double inches;
        double totalInches;

        System.out.println("=== Weight and Height Conversion Program ===");
        System.out.println("1. Convert lbs to kg");
        System.out.println("2. Convert kg to lbs");
        System.out.println("3. Convert cm to feet & inches");
        System.out.println("4. Convert feet & inches to cm");
        System.out.println("Select an option (1-4): ");

        System.out.println("Enter choice for weight: ");
        int choice = scanner.nextInt();
        System.out.println("Enter choice for height: ");
        int choice2 = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter your weight in lbs: ");
                weight = scanner.nextDouble();
                newWeight = weight * 0.45359237;
                System.out.printf("Your weight in kg: %.2f kg\n", newWeight);
                break;

            case 2:
                System.out.print("Enter your weight in kg: ");
                weight = scanner.nextDouble();
                newWeight = weight / 0.45359237;
                System.out.printf("Your weight in lbs: %.2f lbs\n", newWeight);
                break;
            default:
                System.out.println("Invalid selection. Please run the program again.");
                break;
        }
        switch(choice2) {
            case 3:
                System.out.print("Enter your height in cm: ");
                heightCm = scanner.nextDouble();
                totalInches = heightCm / 2.54;
                feet = (int) (totalInches / 12);
                inches = totalInches % 12;
                System.out.printf("Your height: %.0f ft %.1f in\n", feet, inches);
                break;

            case 4:
                System.out.print("Enter feet: ");
                feet = scanner.nextDouble();
                System.out.print("Enter inches: ");
                inches = scanner.nextDouble();
                totalInches = (feet * 12) + inches;
                heightCm = totalInches * 2.54;
                System.out.printf("Your height in cm: %.2f cm\n", heightCm);
                break;
        
            default:
                System.out.println("Invalid selection. Please run the program again.");
                break;
        }

        scanner.close();
    }
}
