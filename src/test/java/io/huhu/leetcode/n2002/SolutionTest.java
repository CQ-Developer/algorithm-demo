package io.huhu.leetcode.n2002;

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
    void test(String s, int res) {
        assertEquals(res, solution.maxProduct(s));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments("leetcodecom", 9), arguments("bb", 1), arguments("accbcaxxcxx", 25));
    }

}