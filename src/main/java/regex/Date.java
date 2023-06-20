package regex;

import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "((19|20)[0-9][0-9][- /.](0[0-9]|1[0-2])[- /.]([0-2][0-9]|3[0-1])|" +
                "([0-2][0-9]|3[0-1])[- /.](0[0-9]|1[0-2])[- /.](19|20)[0-9][0-9])";


        String ip = scanner.nextLine();
        if (ip.matches(regex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // start coding here
    }
}
