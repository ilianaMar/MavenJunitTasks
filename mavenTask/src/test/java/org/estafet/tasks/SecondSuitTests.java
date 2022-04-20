package org.estafet.tasks;
import org.estafet.tasks.support.Names;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Second test suite")
public class SecondSuitTests {
    @DisplayName("#1: Assume true test")
    @ParameterizedTest
    @EnumSource(Names.class)
    void assumptionTrueMatching(Names name){
        assumeTrue(name.name().isEmpty());
    }

    @DisplayName("#2: Assume false test")
    @ParameterizedTest
    @EnumSource(Names.class)
    void assumptionFalseMatching(Names name){
        assumeFalse(name.name().isEmpty());
    }

    @TestFactory
    @ParameterizedTest
    @EnumSource(Names.class)
    Collection<DynamicTest> dynamicTestsFromCollection() {
        Names val = Names.Iliana;
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, Integer.sum(2, 2))),
                dynamicTest("3rd dynamic test", () ->  assertFalse(val.name().isEmpty()))
        );
    }
}
