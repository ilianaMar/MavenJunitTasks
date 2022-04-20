package org.estafet.tasks;
import org.estafet.tasks.support.Names;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Second test suite")
class SecondSuitTests {
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
}
