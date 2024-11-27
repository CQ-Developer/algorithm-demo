package io.huhu.leetcode.n1641;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(int n, int ans) {
        assertEquals(ans, code.countVowelStrings(n));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments(1, 5), arguments(2, 15), arguments(33, 66045));
    }

}