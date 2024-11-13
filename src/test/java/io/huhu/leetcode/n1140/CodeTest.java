package io.huhu.leetcode.n1140;

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
    @MethodSource("templates")
    void test(int[] piles, int expected) {
        Assertions.assertEquals(expected, code.stoneGameII(piles));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 7, 9, 4, 4}, 10),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 100}, 104));
    }

}