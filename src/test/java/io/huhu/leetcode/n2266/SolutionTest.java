package io.huhu.leetcode.n2266;

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
    void test(String pressedKeys, int res) {
        assertEquals(res, solution.countTexts(pressedKeys));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments("22233", 8),
                arguments("222222222222222222222222222222222222", 82876089));
    }

}