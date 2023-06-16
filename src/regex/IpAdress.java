package regex;

import java.util.Scanner;

public class IpAdress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^((25[0-5]|(2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]))(\\.(?!$)|$)){4}$";


        String ip = scanner.next();
        if (ip.matches(regex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // start coding here
    }
}
