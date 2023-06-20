package unittest;

public class Calculator {

    public int maxOf(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
    public boolean isEven(int a) {
        return a % 2 == 0;
    }
}
