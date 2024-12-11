package io.huhu.leetcode.n2063;

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
    void test(String word, long res) {
        assertEquals(res, solution.countVowels(word));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments("aba", 6), arguments("abc", 3), arguments("ltcd", 0));
    }

}