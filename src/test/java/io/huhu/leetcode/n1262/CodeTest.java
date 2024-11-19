package io.huhu.leetcode.n1262;

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
    @MethodSource("cases")
    void test(int[] nums, int ans) {
        Assertions.assertEquals(ans, code.maxSumDivThree(nums));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 6, 5, 1, 8}, 18),
                Arguments.arguments(new int[]{4}, 0),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4}, 12));
    }

}