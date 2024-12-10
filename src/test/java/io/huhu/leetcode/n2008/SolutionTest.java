package io.huhu.leetcode.n2008;

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
    void test(int n, int[][] rides, long res) {
        assertEquals(res, solution.maxTaxiEarnings(n, rides));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(5, new int[][]{{2, 5, 4}, {1, 5, 1}}, 7),
                arguments(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}, 20));
    }

}