import java.util.Scanner;

/* Исключения */

class UserLimitExceededException extends Exception {
    public UserLimitExceededException(String message) {
        super(message);
    }
}

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

/* Основной класс*/

public class AuthSystem {

    private static String[] usernames = new String[15];
    private static String[] passwords = new String[15];

    private static String[] forbiddenWords = new String[20];
    private static int forbiddenCount = 5;

    public static void main(String[] args) {

        forbiddenWords[0] = "admin";
        forbiddenWords[1] = "pass";
        forbiddenWords[2] = "password";
        forbiddenWords[3] = "qwerty";
        forbiddenWords[4] = "ytrewq";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                printMenu();
                int choice = readInt(scanner);

                switch (choice) {
                    case 1:
                        registerUser(scanner);
                        break;
                    case 2:
                        deleteUser(scanner);
                        break;
                    case 3:
                        authenticateUser(scanner);
                        break;
                    case 4:
                        addForbiddenWord(scanner);
                        break;
                    case 5:
                        System.out.println("Программа завершена.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный пункт меню.");
                }

            } catch (UserLimitExceededException |
                     InvalidUsernameException |
                     InvalidPasswordException |
                     UserNotFoundException |
                     AuthenticationException e) {

                System.out.println("Ошибка: " + e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно вводить число.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1 - Добавить пользователя");
        System.out.println("2 - Удалить пользователя");
        System.out.println("3 - Аутентификация");
        System.out.println("4 - Добавить запрещенное слово");
        System.out.println("5 - Выход");
        System.out.print("Выберите пункт: ");
    }

    private static int readInt(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void registerUser(Scanner scanner)
            throws UserLimitExceededException,
                   InvalidUsernameException,
                   InvalidPasswordException {

        if (getUserCount() >= 15) {
            throw new UserLimitExceededException("Достигнут лимит 15 пользователей.");
        }

        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        validateUsername(username);

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        validatePassword(password);

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] == null) {
                usernames[i] = username;
                passwords[i] = password;
                System.out.println("Пользователь успешно зарегистрирован.");
                return;
            }
        }
    }

    private static void deleteUser(Scanner scanner)
            throws UserNotFoundException {

        System.out.print("Введите имя пользователя для удаления: ");
        String username = scanner.nextLine();

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] != null && usernames[i].equals(username)) {
                usernames[i] = null;
                passwords[i] = null;
                System.out.println("Пользователь удален.");
                return;
            }
        }

        throw new UserNotFoundException("Такого пользователя не существует.");
    }

    private static void authenticateUser(Scanner scanner)
            throws AuthenticationException {

        System.out.print("Введите имя: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] != null &&
                usernames[i].equals(username) &&
                passwords[i].equals(password)) {

                System.out.println("Пользователь успешно аутентифицирован.");
                return;
            }
        }

        throw new AuthenticationException("Неверное имя пользователя или пароль.");
    }

    private static void addForbiddenWord(Scanner scanner) {

        if (forbiddenCount >= forbiddenWords.length) {
            System.out.println("Список запрещенных слов заполнен.");
            return;
        }

        System.out.print("Введите запрещенное слово: ");
        forbiddenWords[forbiddenCount] = scanner.nextLine();
        forbiddenCount++;

        System.out.println("Слово добавлено.");
    }

    private static void validateUsername(String username)
            throws InvalidUsernameException {

        if (username.length() < 5) {
            throw new InvalidUsernameException("Имя должно быть минимум 5 символов.");
        }

        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                throw new InvalidUsernameException("Имя не должно содержать пробелы.");
            }
        }
    }

    private static void validatePassword(String password)
            throws InvalidPasswordException {

        if (password.length() < 10) {
            throw new InvalidPasswordException("Пароль должен быть минимум 10 символов.");
        }

        int digits = 0;
        int specials = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (c == ' ') {
                throw new InvalidPasswordException("Пароль не должен содержать пробелы.");
            }

            if (c >= '0' && c <= '9') {
                digits++;
            } else if ((c >= 'a' && c <= 'z') ||
                       (c >= 'A' && c <= 'Z')) {
                // Текст только латиница 
            } else {
                specials++;
            }
        }

        if (digits < 3) {
            throw new InvalidPasswordException("Пароль должен содержать минимум 3 цифры.");
        }

        if (specials < 1) {
            throw new InvalidPasswordException("Пароль должен содержать минимум 1 специальный символ.");
        }

        String lower = password.toLowerCase();

        for (int i = 0; i < forbiddenCount; i++) {
            if (lower.contains(forbiddenWords[i])) {
                throw new InvalidPasswordException(
                        "Пароль содержит запрещенное слово: " + forbiddenWords[i]);
            }
        }
    }

    private static int getUserCount() {
        int count = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] != null) {
                count++;
            }
        }
        return count;
    }
}
