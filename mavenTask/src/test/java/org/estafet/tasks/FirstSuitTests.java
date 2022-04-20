package org.estafet.tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First test suite")
class FirstSuitTests {
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
        Faker faker;
        @BeforeEach
        void createNewFakerObject() {
            faker = new Faker();
        }

        @Test
        @DisplayName("#1: Assert random first and last name are not empty strings")
        void shouldAssertFirstAndLastNameAreNotEmpty()
        {
            String fName = faker.name().firstName();
            String lName = faker.name().lastName();
            assertFalse(fName.isEmpty() && fName.isBlank());
            assertFalse(lName.isEmpty() && lName.isBlank());
        }

        @Test
        @DisplayName("#2: Assert array with random numbers is not empty ")
        void shouldAssertArrayWithRandomNumbersIsNotEmpty()
        {
            ArrayList<Integer> newArray = new ArrayList<>();
            newArray.add(faker.number().numberBetween(1,10));
            newArray.add(faker.number().numberBetween(11,20));
            newArray.add(faker.number().numberBetween(21,30));
            assertEquals( 3, newArray.size());
        }
    }

    @Nested
    @DisplayName("Nested second class tests")
    class NestedSecondClassTests {
        Faker faker;
        @BeforeEach
        void createNewFakerObject() {
            faker = new Faker();
        }

        @Test
        @DisplayName("#1: Assert equal of sum of two numbers")
        void shouldAssertEqualSumOfTwoNumbers()
        {
            int firstNumber = faker.number().numberBetween(1,10);
            int secondNumber = faker.number().numberBetween(21,30);
            int sum = firstNumber + secondNumber;
            assertEquals(sum, Integer.sum(firstNumber, secondNumber));
        }

        @Test
        @DisplayName("#1: Assert equal of sum of two numbers")
        void shouldAssertEqualFloatNumbers()
        {
            double firstNumber = faker.number().randomDouble(2, 1, 10);
            double secondNumber = faker.number().randomDouble(2, 11, 20);
            double sum = firstNumber + secondNumber;
            assertNotEquals(sum, (int)Double.sum(firstNumber, secondNumber));
        }
    }

    @Nested
    @DisplayName("Nested third class tests")
    class NestedThirdClassTests {

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
                "0,    1,   1",
                "1,    2,   3",
                "49,  51, 100",
                "1,  100, 101"
        })
        void assertSumIsEqualsExpectedResult(int firstNumber, int secondNumber, int expectedResult) {
            String msg = String.format("First Number %s + Second Number %s = Expected result %s",
                    firstNumber, secondNumber , expectedResult);
            assertEquals(expectedResult, Integer.sum(firstNumber, secondNumber), msg);

        }

        @ParameterizedTest(name = "Test with string {0}")
        @ValueSource(strings = { "iliana", "markova", "playing", "with", "junit5"})
        void checkInputValuesAreNotEmpty(String  value){
            assertFalse(value.isEmpty() && value.isBlank());
        }
    }
}
