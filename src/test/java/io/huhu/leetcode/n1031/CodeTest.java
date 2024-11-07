package io.huhu.leetcode.n1031;

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
    void test(int[] nums, int firstLen, int secondLen, int expected) {
        Assertions.assertEquals(expected, code.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2, 20),
                Arguments.arguments(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2, 29),
                Arguments.arguments(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3, 31));
    }

}