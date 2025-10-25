import java.util.Scanner;

public class first_task_variant_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть першу дату (день місяць рік): ");
        int day1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int year1 = scanner.nextInt();

        System.out.print("Введіть другу дату (день місяць рік): ");
        int day2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int year2 = scanner.nextInt();


        if (year1 == year2) {
            if (month1 == month2) {

                if (day1 == day2) {
                    System.out.println("Дати однакові.");
                } else if (day1 < day2) {
                    System.out.println("Перша дата раніша.");
                } else {
                    System.out.println("Друга дата раніша.");
                }

            } else {

                switch (month1 < month2 ? 1 : 2) {
                    case 1:
                        System.out.println("Перша дата раніша.");
                        break;
                    case 2:
                        System.out.println("Друга дата раніша.");
                        break;
                }
            }

        } else {

            switch (year1 < year2 ? 1 : 2) {
                case 1:
                    System.out.println("Перша дата раніша.");
                    break;
                case 2:
                    System.out.println("Друга дата раніша.");
                    break;
            }
        }

        scanner.close();

    }
}
