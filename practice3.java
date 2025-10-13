import java.util.Scanner;
import java.util.Formatter;

public class practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int intValue = scanner.nextInt();

        System.out.print("Введіть число з плаваючою точкою: ");
        double doubleValue = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Введіть строку: ");
        String stringValue = scanner.nextLine();

        System.out.print("Введіть логічне значення (true/false): ");
        boolean boolValue = scanner.nextBoolean();

        System.out.println("\n--- Вивід даних у різних форматах ---\n");

        System.out.printf("1) Ціле число в десятковій системі: %d%n", intValue);
        System.out.printf("2) Ціле число в шістнадцятковій системі: %x%n", intValue);
        System.out.printf("3) Ціле число в вісімковій системі: %o%n", intValue);
        System.out.printf("4) Число з плаваючою точкою (2 знаки після коми): %.2f%n", doubleValue);
        System.out.printf("5) Число в науковому форматі: %e%n", doubleValue);
        System.out.printf("6) Строка з шириною 15: %15s%n", stringValue);
        System.out.printf("7) Обрізана строка до 5 символів: %.5s%n", stringValue);
        System.out.printf("8) Логічне значення: %b%n", boolValue);

        String formattedString = String.format("9) Комбінований формат: int=%d, double=%.1f, bool=%b", intValue, doubleValue, boolValue);
        System.out.println(formattedString);

        Formatter formatter = new Formatter();
        formatter.format("10) Використання Formatter: str='%s', hex int=%x", stringValue, intValue);
        System.out.println(formatter);
        formatter.close();

        scanner.close();
    }
}
