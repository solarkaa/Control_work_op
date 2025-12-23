import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();

        String result = "";
        boolean toUpper = false;

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == '-' || ch == '_') {
                toUpper = true;
            } else {
                if (toUpper) {
                    result = result + Character.toUpperCase(ch);
                    toUpper = false;
                } else {
                    result = result + Character.toLowerCase(ch);
                }
            }
        }

        System.out.println("CamelCase: " + result);
    }
}
