package hasfmap;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyElements = scanner.nextInt();
        Set<String> set = new TreeSet<>();
        int i = 0;
        while (i < howManyElements) {
            set.add(scanner.next());
            i ++;
        }
        set.forEach(System.out::println);
    }
}
