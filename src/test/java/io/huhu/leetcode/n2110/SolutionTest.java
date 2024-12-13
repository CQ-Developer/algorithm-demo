package io.huhu.leetcode.n2110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    void test(int[] prices, long res) {
        Assertions.assertEquals(res, solution.getDescentPeriods(prices));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{3, 2, 1, 4}, 7),
                arguments(new int[]{8, 6, 7, 7}, 4),
                arguments(new int[]{1}, 1));
    }

}