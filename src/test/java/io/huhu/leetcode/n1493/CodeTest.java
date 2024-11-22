package io.huhu.leetcode.n1493;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(int[] nums, int ans) {
        assertEquals(ans, code.longestSubarray(nums));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, 1, 0, 1}, 3),
                arguments(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                arguments(new int[]{1, 1, 1}, 2));
    }

}