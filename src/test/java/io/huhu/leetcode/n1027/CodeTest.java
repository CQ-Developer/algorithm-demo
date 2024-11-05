package io.huhu.leetcode.n1027;

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
    @MethodSource("templates")
    void test(int[] nums, int expected) {
        assertEquals(expected, code.longestArithSeqLength(nums));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                arguments(new int[]{3, 6, 9, 12}, 4),
                arguments(new int[]{9, 4, 7, 2, 10}, 3),
                arguments(new int[]{20, 1, 15, 3, 10, 5, 8}, 4));
    }

}