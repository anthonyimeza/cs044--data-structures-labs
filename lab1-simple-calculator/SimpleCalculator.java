
import java.util.Scanner;


public class SimpleCalculator {

    private static double num1, num2;
    private static char operator;
    private static double result;

    public static void main(String[] args) {

        char choice;

        Scanner sc = new Scanner(System.in);

        do {
                System.out.println("Enter your first number:");
                num1 = sc.nextDouble();

                System.out.println("Enter your Operator (+, -, *, /):");
                operator = sc.next().charAt(0);

                System.out.println("Enter your second number:");
                num2 = sc.nextDouble();

                switch (operator) {
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
                        if (num2 == 0) {
                            System.out.println("Cannot divide by Zero.");
                            return;
                        } else {
                            result = num1 / num2;
                        }
                        break;

                    default:
                        System.out.println("Operator is Invalid. Please try again.");
                        return;
                }

                System.out.println("Your equation is:");
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

                System.out.println("Would you like to do another calculation? [Enter Y]");
                choice = sc.next().toLowerCase().charAt(0);

            } while (choice == 'y');

            System.out.println("All calculations done. Stopping calculator...");
            sc.close();
        }
}
