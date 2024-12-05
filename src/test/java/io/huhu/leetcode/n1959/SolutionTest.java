package io.huhu.leetcode.n1959;

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
    void test(int[] nums, int k, int res) {
        assertEquals(res, solution.minSpaceWastedKResizing(nums, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{10, 20}, 0, 10),
                arguments(new int[]{10, 20, 30}, 1, 10),
                arguments(new int[]{10, 20, 15, 30, 20}, 2, 15));
    }

}