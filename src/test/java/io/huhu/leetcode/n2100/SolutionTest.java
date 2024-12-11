package io.huhu.leetcode.n2100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
    void test(int[] security, int time, List<Integer> res) {
        assertIterableEquals(res, solution.goodDaysToRobBank(security, time));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{5, 3, 3, 3, 5, 6, 2}, 2, List.of(2, 3)),
                arguments(new int[]{1, 1, 1, 1, 1}, 0, List.of(0, 1, 2, 3, 4)),
                arguments(new int[]{1, 2, 3, 4, 5, 6}, 2, List.of()));
    }

}