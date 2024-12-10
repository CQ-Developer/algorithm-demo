package io.huhu.leetcode.n2054;

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
    void test(int[][] events, int res) {
        assertEquals(res, solution.maxTwoEvents(events));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}, 4),
                arguments(new int[][]{{1, 3, 2}, {4, 5, 2}, {1, 5, 5}}, 5),
                arguments(new int[][]{{1, 5, 3}, {1, 5, 1}, {6, 6, 5}}, 8));
    }

}