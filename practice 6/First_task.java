import java.util.Random;

public class First_task {
    
    public static void main(String[] args) {
        int size = 20; 
        int[] arr = new int[size];
        Random rand = new Random();

        int even = 0, odd = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100); 
            if (arr[i] % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Масив:");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nКількість парних: " + even);
        System.out.println("Кількість непарних: " + odd);
    }
}
