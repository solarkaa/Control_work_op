import java.util.Scanner;

public class First_work {
    public static void main(String[] args) {
        System.out.println("Інформація про примітивні типи Java:\n");

        System.out.println("byte:    " + Byte.BYTES + " байт (" + Byte.SIZE + " біт), "
                + "мін = " + Byte.MIN_VALUE + ", макс = " + Byte.MAX_VALUE);

        System.out.println("short:   " + Short.BYTES + " байт (" + Short.SIZE + " біт), "
                + "мін = " + Short.MIN_VALUE + ", макс = " + Short.MAX_VALUE);

        System.out.println("int:     " + Integer.BYTES + " байт (" + Integer.SIZE + " біт), "
                + "мін = " + Integer.MIN_VALUE + ", макс = " + Integer.MAX_VALUE);

        System.out.println("long:    " + Long.BYTES + " байт (" + Long.SIZE + " біт), "
                + "мін = " + Long.MIN_VALUE + ", макс = " + Long.MAX_VALUE);

        System.out.println("float:   " + Float.BYTES + " байт (" + Float.SIZE + " біт), "
                + "мін = " + Float.MIN_VALUE + ", макс = " + Float.MAX_VALUE);

        System.out.println("double:  " + Double.BYTES + " байт (" + Double.SIZE + " біт), "
                + "мін = " + Double.MIN_VALUE + ", макс = " + Double.MAX_VALUE);

        System.out.println("char:    " + Character.BYTES + " байт (" + Character.SIZE + " біт), "
                + "мін = " + (int) Character.MIN_VALUE + ", макс = " + (int) Character.MAX_VALUE);

        System.out.println("boolean: розмір залежить від JVM (true/false)\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть число типу int: ");
        String intStr = sc.nextLine();
        int intValue = Integer.parseInt(intStr);
        System.out.println("Ви ввели int = " + intValue);

        System.out.print("Введіть число типу double: ");
        String doubleStr = sc.nextLine();
        double doubleValue = Double.parseDouble(doubleStr);
        System.out.println("Ви ввели double = " + doubleValue);

        System.out.print("Введіть значення типу boolean (true/false): ");
        String boolStr = sc.nextLine();
        boolean boolValue = Boolean.parseBoolean(boolStr);
        System.out.println("Ви ввели boolean = " + boolValue);

        System.out.print("Введіть символ типу char: ");
        String charStr = sc.nextLine();
        char charValue = charStr.charAt(0);
        System.out.println("Ви ввели char = " + charValue);

        sc.close();
    }
}
