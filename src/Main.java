import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Bye");
                return;
            } else if (input.isEmpty() || input.equals(" ")) {
                System.out.println("No input.");
            } else {
                System.out.println("Error: unknown command!");
            }
        }
    }
}