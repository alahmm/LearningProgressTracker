package unittest;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//New
public class LifeCycleTest {

    LifeCycleTest() {
        System.out.println("Test Class Constructor");//it will be showed just ones and no more needed that beforeAll/afterAll to be static
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("Before the test fixture");
    }

    @AfterAll
    void afterAll() {
        System.out.println("After the test fixture");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }
}
