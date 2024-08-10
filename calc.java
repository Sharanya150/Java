import java.util.Scanner;
public class calc 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.print("Enter the number of operands to perform calculations on: ");
        int n = scanner.nextInt();
        
        double[] op = new double[n];
        
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Operand " + (i + 1) + ": ");
            op[i] = scanner.nextDouble();
        }
        
        System.out.println();
        System.out.println("Select an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println();
        System.out.print("Enter your choice (1-4): ");

        int choice = scanner.nextInt();
        double result = op[0]; 

        switch (choice) {
            case 1:
                for (int i = 1; i < n; i++) {
                    result += op[i];
                }
                System.out.println("\nResult: The sum is " + result);
                break;
            case 2:
                for (int i = 1; i < n; i++) {
                    result -= op[i];
                }
                System.out.println("\nResult: The difference is " + result);
                break;
            case 3:
                for (int i = 1; i < n; i++) {
                    result *= op[i];
                }
                System.out.println("\nResult: The product is " + result);
                break;
            case 4:
                for (int i = 1; i < n; i++) {
                    if (op[i] != 0) {
                        result /= op[i];
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        return; 
                    }
                }
                System.out.println("Result: The quotient is " + result);
                break;
            default:
                System.out.println("\nInvalid choice! Please select a valid operation.");
                break;
        }

        scanner.close();

        System.out.println("\nThank you for using the Simple Calculator!");
    }
}
