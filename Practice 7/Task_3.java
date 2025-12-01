import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[5][5];

        System.out.println("Введите элементы матрицы 5x5:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }


        int det = determinant(matrix);
        System.out.println("\nВведенная матрица:");
        printMatrix(matrix);
        System.out.println("\nВизначник матриці = " + det);
        sc.close();
    }


    public static int determinant(int[][] a) {
        int n = a.length;
        if (n == 1) return a[0][0];
        if (n == 2) {
            return a[0][0] * a[1][1] - a[0][1] * a[1][0];
        }
        int det = 0;
        for (int col = 0; col < n; col++) {
            det += a[0][col] * cofactor(a, 0, col);
        }

        return det;
    }

    public static int cofactor(int[][] a, int row, int col) {
        return (int) Math.pow(-1, row + col) * determinant(minor(a, row, col));
    }


    public static int[][] minor(int[][] a, int row, int col) {
        int n = a.length;
        int[][] m = new int[n - 1][n - 1];
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


    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.printf("%4d", x);
            }
            System.out.println();
        }
    }
}
