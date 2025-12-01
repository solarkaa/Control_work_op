import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество строк (n >= 1): ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("n должно быть >= 1");
            return;
        }

        int peak = (n + 1) / 2;

        
        int[][] pyramid = new int[n][];
        int value = 1;
        for (int i = 0; i < n; i++) {
            int len = (i < peak) ? (i + 1) : (n - i);
            pyramid[i] = new int[len];
            for (int j = 0; j < len; j++) {
                pyramid[i][j] = value++;
            }
        }


        int maxLen = peak;

        System.out.println("\nОбычный порядок (пирамидой):");
        printPyramid(pyramid, maxLen);

        System.out.println("\nОбратный порядок (пирамидой):");
        int[][] reversed = reverseRows(pyramid);
        printPyramid(reversed, maxLen);

        sc.close();
    }

    
    private static void printPyramid(int[][] arr, int maxLen) {
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length;
            int spacesCount = (maxLen - len) * 2;
            for (int s = 0; s < spacesCount; s++) System.out.print(" ");
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j]);
                if (j != len - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }


    private static int[][] reverseRows(int[][] src) {
        int n = src.length;
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = src[n - 1 - i];
        }
        return res;
    }
}
