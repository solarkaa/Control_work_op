import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine().trim();

        input = input + " ";

        String currentWord = "";
        String shortest = "";
        String longest = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') {
                currentWord = currentWord + ch;

            } else {
                if (!currentWord.isEmpty()) {

                    if (shortest.equals("") || currentWord.length() < shortest.length()) {
                        shortest = currentWord;
                    }

                    if (currentWord.length() > longest.length()) {
                        longest = currentWord;
                    }

                    currentWord = "";
                }
            }
        }

        System.out.println("Найменше слово: " + shortest + " (" + shortest.length() + " символи)");
        System.out.println("Найдовше слово: " + longest + " (" + longest.length() + " символи)");
    }
}
