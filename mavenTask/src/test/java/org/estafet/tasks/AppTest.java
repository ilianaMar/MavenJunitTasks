package org.estafet.tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
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

    Faker faker;
    @BeforeEach
    void createNewFakerObject() {
        faker = new Faker();
    }

    @Test
    @DisplayName("First Test")
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

}
