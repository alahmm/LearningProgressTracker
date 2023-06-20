package regex;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$";

        String time = scanner.nextLine();
        System.out.println(time.matches(regex) && time.length() >= 12? "YES" : "NO");
    }
}
