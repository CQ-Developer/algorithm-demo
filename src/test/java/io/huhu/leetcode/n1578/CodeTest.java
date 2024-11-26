package io.huhu.leetcode.n1578;

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
    void test(String colors, int[] neededTime, int ans) {
        assertEquals(ans, code.minCost(colors, neededTime));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments("abaac", new int[]{1, 2, 3, 4, 5}, 3),
                arguments("abc", new int[]{1, 2, 3}, 0),
                arguments("aabaa", new int[]{1, 2, 3, 4, 1}, 2));
    }

}