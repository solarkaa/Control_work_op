import java.util.Scanner;

public class All_tasks {

    public static String inputValidString() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введіть строку (мінімум 2 слова, кожне не менше 3 символів):");
            input = scanner.nextLine().trim();

            String[] words = input.split("\\s+");

            if (words.length < 2) {
                System.out.println("Помилка: потрібно мінімум 2 слова.");
                continue;
            }

            boolean isValid = true;
            for (String word : words) {
                if (word.length() < 3) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return input;
            } else {
                System.out.println("Помилка: кожне слово має містити мінімум 3 символи.");
            }
        }
    }


    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }


    public static String reverseEachWord(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse()).append(" ");
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userString = inputValidString();

        System.out.println("Оберіть дію:");
        System.out.println("1 - Перевернути всю строку");
        System.out.println("2 - Перевернути кожне слово окремо");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Результат:");
                System.out.println(reverseString(userString));
                break;
            case 2:
                System.out.println("Результат:");
                System.out.println(reverseEachWord(userString));
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }
}
