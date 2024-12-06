package io.huhu.leetcode.n1981;

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
    void test(int[][] mat, int target, int res) {
        assertEquals(res, solution.minimizeTheDifference(mat, target));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 13, 0),
                arguments(new int[][]{{1}, {2}, {3}}, 100, 94),
                arguments(new int[][]{{1, 2, 9, 8, 7}}, 6, 1));
    }

}