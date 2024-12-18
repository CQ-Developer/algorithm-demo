package io.huhu.leetcode.n2310;

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
    void test(int num, int k, int res) {
        assertEquals(res, solution.minimumNumbers(num, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments(58, 9, 2), arguments(37, 2, -1), arguments(0, 7, 0));
    }

}