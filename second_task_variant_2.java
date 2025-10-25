import java.util.Scanner;

public class second_task_variant_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;


        do {
            System.out.print("Введіть текст: ");
            text = scanner.nextLine().trim();
        } while (text.isEmpty());

        
        int count = 0;
        int i = 0;


        while (i < text.length()) {
            char ch = text.charAt(i);


            if (ch == '.' || ch == '!' || ch == '?') {
                count++;
            }
            i++;
        }

        System.out.println("Кількість речень у тексті: " + count);

        scanner.close();
    }
}
