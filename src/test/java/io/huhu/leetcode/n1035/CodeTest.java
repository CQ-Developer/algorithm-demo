package io.huhu.leetcode.n1035;

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
    void test(int[] nums1, int[] nums2, int expected) {
        Assertions.assertEquals(expected, code.maxUncrossedLines(nums1, nums2));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 2}, new int[]{1, 2, 4}, 2),
                Arguments.arguments(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}, 3),
                Arguments.arguments(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}, 2));
    }

}