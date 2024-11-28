package io.huhu.leetcode.n1690;

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
    void test(int[] stones, int ans) {
        assertEquals(ans, code.stoneGameVII(stones));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments(new int[]{5, 3, 1, 4, 2}, 6), arguments(new int[]{7, 90, 5, 1, 100, 10, 10, 2}, 122));
    }

}