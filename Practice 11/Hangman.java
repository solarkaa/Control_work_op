import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;

public class Hangman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] easy_words = {"cat", "house", "apple", "mouse", "man"};
        String[] medium_words = {"school", "car", "teacher", "phone"};
        String[] hard_words = {"program", "algorithm", "computer", "java"};

        int choice = 0;
        boolean validChoice = false;

        System.out.println("Hangman Game");

        while (!validChoice) {
            try {
                System.out.println("Choose difficulty:");
                System.out.println("1 - Easy");
                System.out.println("2 - Medium");
                System.out.println("3 - Hard");

                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException("Choice must be 1, 2 or 3.");
                }

                validChoice = true;

            } catch (InputMismatchException e) {
                System.out.println("Enter a number (1-3).");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String word;

        if (choice == 1) {
            word = easy_words[random.nextInt(easy_words.length)];
        } else if (choice == 2) {
            word = medium_words[random.nextInt(medium_words.length)];
        } else {
            word = hard_words[random.nextInt(hard_words.length)];
        }

        word = word.toLowerCase();

        char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }

        char[] usedLetters = new char[26];
        int usedCount = 0;

        int errors = 0;
        final int MAX_ERRORS = 6;
        boolean win = false;

        while (errors < MAX_ERRORS && !win) {

            drawHangman(errors);

            System.out.print("\nWord: ");
            for (int i = 0; i < hiddenWord.length; i++) {
                System.out.print(hiddenWord[i] + " ");
            }

            System.out.println("\nErrors: " + errors + "/" + MAX_ERRORS);
            System.out.print("Enter a letter: ");

            try {
                String input = scanner.nextLine().toLowerCase();

                if (input.length() != 1) {
                    throw new IllegalArgumentException("Enter exactly ONE letter.");
                }

                char letter = input.charAt(0);

                if (letter < 'a' || letter > 'z') {
                    throw new IllegalArgumentException("Only English letters allowed.");
                }

                for (int i = 0; i < usedCount; i++) {
                    if (usedLetters[i] == letter) {
                        throw new IllegalStateException("Letter already used.");
                    }
                }

                usedLetters[usedCount] = letter;
                usedCount++;

                boolean found = false;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        hiddenWord[i] = letter;
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No such letter.");
                    errors++;
                }

                win = true;
                for (int i = 0; i < hiddenWord.length; i++) {
                    if (hiddenWord[i] == '_') {
                        win = false;
                        break;
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        drawHangman(errors);

        if (win) {
            System.out.println("\nYou win! Word: " + word);
        } else {
            System.out.println("\nYou lose. The word was: " + word);
        }

        scanner.close();
    }

    static void drawHangman(int errors) {

        System.out.println("\n +---+");
        System.out.println(" |   |");

        System.out.println(errors >= 1 ? " |   O" : " |");
        System.out.println(errors >= 2 ? " |   |" : " |");

        if (errors == 3) System.out.println(" |  /|");
        else if (errors >= 4) System.out.println(" |  /|\\");
        else System.out.println(" |");

        if (errors >= 5) System.out.println(" |  / \\");
        else System.out.println(" |");

        System.out.println(" |");
        System.out.println("=========");
    }
}