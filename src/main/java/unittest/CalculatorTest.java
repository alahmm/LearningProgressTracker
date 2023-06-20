package unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
class CalculatorTest {

    @Test
    void testMaxFirstArgGreaterThanSecondArg() {
        Calculator calculator = new Calculator();
        int result = calculator.maxOf(2, 1);
        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void testMaxFirstArgLessThanSecondArg() {
        Calculator calculator = new Calculator();
        int result = calculator.maxOf(1, 2);
        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void testMaxFirstArgEqualToSecondArg() {
        Calculator calculator = new Calculator();
        int result = calculator.maxOf(2, 2);
        int expected = 2;

        assertEquals(expected, result);
    }
}*/
//with parametrized Test
class CalculatorTests {

    @ParameterizedTest //or @ParameterizedTest(name = "{index} => maxOf({0}, {1}) == {2}")
    @CsvSource({"2, 1, 2", "1, 2, 2", "1, 1, 1"})
    void testMax(int first, int second, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.maxOf(first, second);

        assertEquals(expected, result);
    }
    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 4, 1000 })
    void testIsEven(int arg) {
        assertTrue(new Calculator().isEven(arg));
    }

    /**
     *
     * @param arg
     */

    @ParameterizedTest
    @EmptySource
    void testEmpty(int[] arg) {
        assertEquals(0, arg.length);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testNullAndEmpty(List<String> arg) {
        assertTrue(arg == null || arg.isEmpty());
    }

    /**
     *
     * @param str
     */
    @ParameterizedTest
    @MethodSource("stringFactory")
    void testStrings(String str) {
        assertFalse(str.isEmpty());
    }

    static List<String> stringFactory() {
        return List.of("apple", "banana", "lemon", "orange");
    }
    /**
     *
     * @param str
     * @param length
     */
    @ParameterizedTest
    @MethodSource("argFactory")
    void testStringLength(String str, int length) {
        assertEquals(length, str.length());
    }

    static List<Arguments> argFactory() {
        return List.of(arguments("apple", 5), arguments("watermelon", 10));
    }
}
