package hasfmap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyNumbers = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        int i = 0;
        while (i < howManyNumbers) {
            int number = scanner.nextInt();
            deque.push(number);
            i ++;
        }
        int j = 0;
        int initialSize = deque.size();
        while (j < initialSize) {
            if (deque.getFirst() % 2 == 0) {
                System.out.println(deque.pop());
            } else {
                deque.offerLast(deque.pop());
            }
            j ++;
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.getLast());
            deque.removeLast();
        }
    }
}
