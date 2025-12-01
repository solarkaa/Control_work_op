import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы (n): ");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.random() * 100;
            }
        }


        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        System.out.print("\nВведите номер строки для минора (от 1 до " + n + "): ");
        int row = sc.nextInt() - 1;

        System.out.print("Введите номер столбца для минора (от 1 до " + n + "): ");
        int col = sc.nextInt() - 1;


        double[][] minorMatrix = minor(matrix, row, col);
        System.out.println("\nМинор матрицы (без строки " + (row + 1) +
                           " и столбца " + (col + 1) + "):");
        printMatrix(minorMatrix);

        sc.close();
    }


    public static double[][] minor(double[][] a, int row, int col) {
        int n = a.length;
        double[][] m = new double[n - 1][n - 1];

        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                m[r][c] = a[i][j];
                c++;
            }
            r++;
        }
        return m;
    }

    
    public static void printMatrix(double[][] a) {
        for (double[] row : a) {
            for (double x : row) {
                System.out.printf("%8.2f", x);
            }
            System.out.println();
        }
    }
}
