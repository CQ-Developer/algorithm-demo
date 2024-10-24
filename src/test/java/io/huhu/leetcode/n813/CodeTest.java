package io.huhu.leetcode.n813;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class CodeTest {

    Code code;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
    }

    @ParameterizedTest
    @MethodSource("examples")
    void test(int[] nums, int k, double expected) {
        Assertions.assertEquals(expected, code.largestSumOfAverages(nums, k));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{9, 1, 2, 3, 9}, 3, 20.0),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, 20.5));
    }

}
