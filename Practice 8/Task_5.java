import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();

        String bad1 = "погане";
        String bad2 = "слово";

        String mask1 = "***";
        String mask2 = "[цензура]";


        String result = input;

        
        result = result.replace(bad1, mask1);
        result = result.replace(bad2, mask2);

        System.out.println("Результат: " + result);
    }
}
