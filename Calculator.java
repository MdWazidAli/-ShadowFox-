import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEnhanced Console-based Calculator");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            //Error Handling is done with the help of switch case

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    performArithmeticOperations(scanner);
                    break;
                case 2:
                    performScientificCalculations(scanner);
                    break;
                case 3:
                    performUnitConversions(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Implement the arithmetic operations:
    private static void performArithmeticOperations(Scanner scanner) {
        System.out.println("\nArithmetic Operations:");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char operation = scanner.next().charAt(0);

        double result = 0;
        boolean validOperation = true;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                validOperation = false;
        }

        if (validOperation) {
            System.out.println("Result: " + result);
        }
    }

    // Implement the scientific calculations
    private static void performScientificCalculations(Scanner scanner) {
        System.out.println("\nScientific Calculations:");
        System.out.println("1. Square Root");
        System.out.println("2. Power");
        System.out.println("3. Sine");
        System.out.println("4. Cosine");
        System.out.println("5. Tangent");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        System.out.print("Enter the number: ");
        double num = scanner.nextDouble();
        double result = 0;

        switch (choice) {
            case 1:
                result = Math.sqrt(num);
                break;
            case 2:
                System.out.print("Enter the exponent: ");
                double exponent = scanner.nextDouble();
                result = Math.pow(num, exponent);
                break;
            case 3:
                result = Math.sin(Math.toRadians(num));
                break;
            case 4:
                result = Math.cos(Math.toRadians(num));
                break;
            case 5:
                result = Math.tan(Math.toRadians(num));
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Result: " + result);
    }

    // Implement the unit conversions
    private static void performUnitConversions(Scanner scanner) {
        System.out.println("\nUnit Conversions:");
        System.out.println("1. Meters to Kilometers");
        System.out.println("2. Kilometers to Meters");
        System.out.println("3. Grams to Kilograms");
        System.out.println("4. Kilograms to Grams");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        System.out.print("Enter the value: ");
        double value = scanner.nextDouble();
        double result = 0;

        switch (choice) {
            case 1:
                result = value / 1000;
                break;
            case 2:
                result = value * 1000;
                break;
            case 3:
                result = value / 1000;
                break;
            case 4:
                result = value * 1000;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Result: " + result);
    }
}