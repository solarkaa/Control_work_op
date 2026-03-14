import java.io.*;
import java.util.Scanner;

public class Practice12 {

    static String fileName = "text.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            showMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice == 1) {
                    writeToFile(scanner);
                } 
                else if (choice == 2) {
                    readFile();
                } 
                else if (choice == 3) {
                    System.out.println("Вихід з редактора...");
                } 
                else {
                    System.out.println("Невірний вибір.");
                }

            } catch (Exception e) {
                System.out.println("Помилка введення.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - Записати до файлу");
        System.out.println("2 - Прочитати увесь файл");
        System.out.println("3 - Вийти");
        System.out.print("Ваш вибір: ");
    }

    public static void writeToFile(Scanner scanner) {
        try {
            System.out.print("Введіть рядок: ");
            String text = scanner.nextLine();

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(text + "\n");
            writer.close();

            System.out.println("Рядок записано у файл.");

        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }

    public static void readFile() {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("\nВміст файлу:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Помилка читання файлу.");
        }
    }
}