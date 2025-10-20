import java.util.*;

public class Task1 {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number between 1 and 5.");
                sc.nextLine();
                continue;
            }

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = readDouble(sc);
            System.out.print("Enter second number: ");
            double num2 = readDouble(sc);

            switch (choice) {
                case 1:
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case 2:
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case 3:
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case 4:
                    try {
                        System.out.println("Result: " + divide(num1, num2));
                    } catch (ArithmeticException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid number. Enter again: ");
                sc.nextLine();
            }
        }
    }
}
