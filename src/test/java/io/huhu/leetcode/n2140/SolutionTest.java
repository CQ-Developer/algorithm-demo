package io.huhu.leetcode.n2140;

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
    void test(int[][] question, long res) {
        assertEquals(res, solution.mostPoints(question));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}, 5),
                arguments(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, 7));
    }

}