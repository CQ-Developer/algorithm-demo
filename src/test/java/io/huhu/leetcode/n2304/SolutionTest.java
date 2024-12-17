package io.huhu.leetcode.n2304;

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
    void test(int[][] grid, int[][] moveCost, int res) {
        assertEquals(res, solution.minPathCost(grid, moveCost));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(
                        new int[][]{{5, 3}, {4, 0}, {2, 1}},
                        new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}},
                        17),
                arguments(
                        new int[][]{{5, 1, 2}, {4, 0, 3}},
                        new int[][]{{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}},
                        6));
    }

}