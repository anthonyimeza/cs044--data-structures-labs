
import java.util.Scanner;

public class PolygonCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

            while (true){

                System.out.println("\n--------Choose your Polygon--------");
                System.out.println("1. Triangle");
                System.out.println("2. Isosceles Triangle");
                System.out.println("3. Equilateral Triangle");
                System.out.println("4. Quadrilateral");
                System.out.println("5. Square");
                System.out.println("6. Rectangle");
                System.out.println("7. Pentagon");
                System.out.println("8. Hexagon");
                System.out.println("9. Octagon");
                System.out.println("10. Stop Process\n");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();

                Polygon poly = null;

                switch (choice){

                    case 1:
                        System.out.println("You chose - Triangle");
                        System.out.println("Enter Side A: ");
                        double t1 = sc.nextDouble();
                        System.out.println("Enter Side B: ");
                        double t2 = sc.nextDouble();
                        System.out.println("Enter Side C: ");
                        double t3 = sc.nextDouble();
                        poly = new Triangle(t1, t2, t3);
                        break;

                    case 2:
                        System.out.println("You chose - Isosceles Triangle");
                        System.out.println("Enter Equal Side: ");
                        double eqS = sc.nextDouble();
                        System.out.println("Enter Base Side: ");
                        double bS = sc.nextDouble();
                        poly = new IsoscelesTriangle(eqS, bS);
                        break;

                    case 3:
                        System.out.println("You chose - Equilateral Triangle");
                        System.out.println("Enter the Side: ");
                        double s = sc.nextDouble();
                        poly = new EquilateralTriangle(s);
                        break;

                    case 4:
                        System.out.println("You chose - Quadrilateral");
                        System.out.println("Enter Side A: ");
                        double q1 = sc.nextDouble();
                        System.out.println("Enter Side B: ");
                        double q2 = sc.nextDouble();
                        System.out.println("Enter Side C: ");
                        double q3 = sc.nextDouble();
                        System.out.println("Enter Side D: ");
                        double q4 = sc.nextDouble();
                        poly = new Quadrilateral(q1, q2, q3, q4);
                        break;

                    case 5:
                        System.out.println("You chose - Square");
                        System.out.println("Enter the Side: ");
                        double sq1 = sc.nextDouble();
                        poly = new Square(sq1);
                        break;

                    case 6:
                        System.out.println("You chose - Rectangle");
                        System.out.println("Enter Side A: ");
                        double r1 = sc.nextDouble();
                        System.out.println("Enter Side B: ");
                        double r2 = sc.nextDouble();
                        poly = new Rectangle(r1, r2);
                        break;

                    case 7:
                        System.out.println("You chose - Pentagon");
                        System.out.println("Enter the Side: ");
                        double p1 = sc.nextDouble();
                        poly = new Pentagon(p1);
                        break;

                    case 8:
                        System.out.println("You chose - Hexagon");
                        System.out.println("Enter the Side: ");
                        double h1 = sc.nextDouble();
                        poly = new Hexagon(h1);
                        break;

                    case 9:
                        System.out.println("You chose - Octagon");
                        System.out.println("Enter the side: ");
                        double o1 = sc.nextDouble();
                        poly = new Octagon(o1);
                        break;

                    case 10:
                        System.out.println("Stopping Process...");
                        System.out.println("Goodbye.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

                if (poly != null){

                    System.out.println("The Area of your shape is: " + poly.getArea() + "\n");
                    System.out.println("The Perimeter of your shapee is: " + poly.getPerimeter());
                }
            }
        }
}