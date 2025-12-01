import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ввод размера матрицы
        System.out.print("Введите размер квадратной матрицы (n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        // Заполнение случайными целыми числами (от -50 до 50)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int)(Math.random() * 101) - 50;
            }
        }

        // Вывод исходной матрицы
        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        // Создание транспонированной матрицы
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        // Вывод транспонированной матрицы
        System.out.println("\nТранспонованая матриця:");
        printMatrix(transposed);

        sc.close();
    }

    // Метод вывода матрицы
    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.printf("%5d", x);
            }
            System.out.println();
        }
    }
}
