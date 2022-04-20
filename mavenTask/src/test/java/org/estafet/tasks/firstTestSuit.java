package org.estafet.tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First test suite with nested classes")
class FirstSuitTests {
    Faker faker;
    @BeforeEach
    void createNewFakerObject() {
        faker = new Faker();
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Print once before all methods");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Print once after all methods");
    }

    @Nested
    @DisplayName("Nested first class tests")
    class NestedFirstClassTests {
        @Test
        @DisplayName("#1: Assert random first and last name are not empty strings")
        public void shouldAssertFirstAndLastNameAreNotEmpty()
        {
            String fName = faker.name().firstName();
            String lName = faker.name().lastName();
            assertFalse(fName.isEmpty() && fName.isBlank());
            assertFalse(lName.isEmpty() && lName.isBlank());
        }

        @Test
        @DisplayName("#2: Assert array with random numbers is not empty ")
        public void shouldAssertArrayWithRandomNumbersIsNotEmpty()
        {
            ArrayList<Integer> newArray = new ArrayList<>();
            newArray.add(faker.number().numberBetween(1,10));
            newArray.add(faker.number().numberBetween(11,20));
            newArray.add(faker.number().numberBetween(21,30));
            assertEquals(newArray.size(), 3);
        }
    }

    @Nested
    @DisplayName("Nested second class tests")
    class NestedSecondClassTests {
        @Test
        @DisplayName("#1: Assert equal of sum of two numbers")
        public void shouldAssertEqualSumOfTwoNumbers()
        {
            int firstNumber = faker.number().numberBetween(1,10);
            int secondNumber = faker.number().numberBetween(21,30);
            int sum = firstNumber + secondNumber;
            assertEquals(Integer.sum(firstNumber, secondNumber), sum);
        }

        @Test
        @DisplayName("#1: Assert equal of sum of two numbers")
        public void shouldAssertEqualFloatNumbers()
        {
            double firstNumber = faker.number().randomDouble(2, 1, 10);
            double secondNumber = faker.number().randomDouble(2, 11, 20);
            double sum = firstNumber + secondNumber;
            assertNotEquals((int)Double.sum(firstNumber, secondNumber), sum);
        }
    }
}
