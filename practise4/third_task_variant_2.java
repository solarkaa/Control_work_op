import java.util.Scanner;

public class third_task_variant_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число N: ");
        int N = scanner.nextInt();

        System.out.println("Прості числа від 1 до " + N + ":");


        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;


            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }


            if (isPrime) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
