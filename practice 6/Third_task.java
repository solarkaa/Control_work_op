import java.util.*;

public class Third_task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println("Початковий масив:");
        System.out.println(Arrays.toString(arr));

        System.out.print("Введіть значення для пошуку: ");
        int findVal = sc.nextInt();

        System.out.print("Введіть нове значення: ");
        int newVal = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == findVal) {
                arr[i] = newVal;
                found = true;
            }
        }

        if (found)
            System.out.println("Значення замінено.");
        else
            System.out.println("Значення не знайдено.");

        System.out.println("Новий масив:");
        System.out.println(Arrays.toString(arr));
    }
}
