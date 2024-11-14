package io.huhu.leetcode.n1155;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("template")
    void test(int n, int k, int target, int ans) {
        Assertions.assertEquals(ans, code.numRollsToTarget(n, k, target));
    }

    static Stream<Arguments> template() {
        return Stream.of(
                Arguments.arguments(1, 6, 3, 1),
                Arguments.arguments(2, 6, 7, 6),
                Arguments.arguments(30, 30, 500, 222616187));
    }

}