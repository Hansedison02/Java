import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter circle radius: ");
        double radius = scanner.nextDouble();

        try {
            if (radius > 1000) {
                throw new IllegalArgumentException("Cannot calculate that far");
            }

            Circle circle = new Circle(radius);
            double area = circle.getArea();
            System.out.println("Circle Area: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}