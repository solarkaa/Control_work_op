import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = sc.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = sc.nextInt();

        double[][] arr = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = Math.random() * 100;
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i % 2 != 0 || j % 2 != 0) {
                    arr[i][j] = Math.sqrt(arr[i][j]);
                }
            }
        }

        System.out.println("\nРезультат:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f\t", arr[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
