package org.estafet.tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    Faker faker = new Faker();

    @Test
    @DisplayName("First Test")
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    @DisplayName("Second test: Assert random first and last name are not empty strings")
    public void shouldAssertFirstAndLastNameAreNotEmpty()
    {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        assertFalse(fName.isEmpty() && fName.isBlank());
        assertFalse(lName.isEmpty() && lName.isBlank());
    }


}
