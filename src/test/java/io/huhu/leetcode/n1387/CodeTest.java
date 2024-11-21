package io.huhu.leetcode.n1387;

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
    void test(int lo, int hi, int k, int ans) {
        assertEquals(ans, code.getKth(lo, hi, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments(12, 15, 2, 13), arguments(7, 11, 4, 7));
    }

}