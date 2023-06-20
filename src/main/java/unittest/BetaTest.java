package unittest;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BetaTest {
    static int number = 14;

    public BetaTest() {
        number *= 2;
    }
    @BeforeAll
    static void method3() {
        number += 11;
    }

    @BeforeEach
    void method2() {
        number -= 4;
    }

    @AfterAll
    static void method4() {
        number /= 3;
    }

    @AfterEach
    void method5() {
        System.out.println(number);
    }

    @Test
    public void method6() {
        number += 9;
    }
}