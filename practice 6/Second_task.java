import java.util.Scanner;

public class Second_task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість кутів: ");
        int n = sc.nextInt();

        int[] angles = new int[n];
        int sum = 0;

        System.out.println("Введіть " + n + " кутів:");
        for (int i = 0; i < n; i++) {
            angles[i] = sc.nextInt();
            sum += angles[i];
        }

        int requiredSum = 180 * (n - 2);

        if (sum == requiredSum)
            System.out.println("Такий багатокутник може існувати.");
        else
            System.out.println("Багатокутник НЕ може існувати.");
    }
}
