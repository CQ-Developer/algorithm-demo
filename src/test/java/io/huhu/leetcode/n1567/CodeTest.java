package io.huhu.leetcode.n1567;

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
    void test(int[] nums, int ans) {
        assertEquals(ans, code.getMaxLen(nums));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, -2, -3, 4}, 4),
                arguments(new int[]{0, 1, -2, -3, -4}, 3),
                arguments(new int[]{-1, -2, -3, 0, 1}, 2));
    }

}