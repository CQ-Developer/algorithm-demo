package io.huhu.leetcode.n1986;

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
    void test(int[] tasks, int sessionTime, int res) {
        assertEquals(res, solution.minSessions(tasks, sessionTime));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, 3, 2),
                arguments(new int[]{3, 1, 3, 1, 1}, 8, 2),
                arguments(new int[]{1, 2, 3, 4, 5}, 15, 1));
    }

}