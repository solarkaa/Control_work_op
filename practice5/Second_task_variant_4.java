import java.util.Scanner;

public class Second_task_variant_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Введіть a: ");
        double a = input.nextDouble();

        System.out.print("Введіть b: ");
        double b = input.nextDouble();

        System.out.print("Введіть x: ");
        double x = input.nextDouble();

        double fx;


        if (x >= 0 && x < 4) {
            fx = Math.cos(x);
        } else if (x == 4) {
            fx = 3 * Math.pow(x, 2) + b * x;
        } else if (x > 4 && x < 9) {
            fx = Math.log(a * x + b);
        } else {
            System.out.println("x не входить у допустимий діапазон [0,9).");
            input.close();
            return;
        }


        System.out.printf("f(%.2f) = %.6f%n", x, fx);

        
        input.close();
    }
}
