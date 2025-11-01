public class First_task_variant_4 {
    public static void main(String[] args) {

        
        double a = 1.256;
        double b = 13.5;
        double c = 4;


        double numerator1 = Math.pow(b, a + 1);
        double denominator1 = Math.cbrt(Math.abs(b - c));
        double part1 = numerator1 / denominator1;


        double numerator2 = a + b / 2.0;
        double denominator2 = 2 * Math.abs(a + b);
        double part2 = numerator2 / denominator2;


        double x = part1 + part2;


        double y = Math.pow((a + 1), -1 / Math.sin(a));


        System.out.printf("x = %.6f%n", x);
        System.out.printf("y = %.6f%n", y);
    }
}
