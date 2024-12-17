package io.huhu.leetcode.n2305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(int[] cookies, int k, int res) {
        assertEquals(res, solution.distributeCookies(cookies, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{8, 15, 10, 20, 8}, 2, 31),
                arguments(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3, 7));
    }

}