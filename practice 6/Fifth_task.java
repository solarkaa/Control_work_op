import java.util.*;

public class Fifth_task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(100);

        System.out.println("Масив:");
        System.out.println(Arrays.toString(arr));

        System.out.print("Перевірити на (1 - зростання, 2 - спадання): ");
        int choice = sc.nextInt();

        boolean check = true;

        if (choice == 1) {
            for (int i = 0; i < n - 1; i++)
                if (arr[i] > arr[i + 1]) check = false;

            System.out.println(check ? "Масив зростає." : "Масив НЕ зростає.");
        } 
        else if (choice == 2) {
            for (int i = 0; i < n - 1; i++)
                if (arr[i] < arr[i + 1]) check = false;

            System.out.println(check ? "Масив спадає." : "Масив НЕ спадає.");
        } 
        else {
            System.out.println("Невірний вибір.");
        }
    }
}
