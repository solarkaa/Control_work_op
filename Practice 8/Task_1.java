import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();
        String normalized = input.toLowerCase().replace(" ", "");
        String reversed = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed = reversed + normalized.charAt(i);
        }

        
        if (normalized.equals(reversed)) {
            System.out.println("Це паліндром.");
        } else {
            System.out.println("Це не паліндром.");
        }
    }
}
