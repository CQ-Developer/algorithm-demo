package io.huhu.leetcode.back.trace.n842;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void splitIntoFibonacci1() {
        var expected1 = List.of(11, 0, 11, 11);
        var expected2 = List.of(110, 1, 111);
        var actual = solution.splitIntoFibonacci("1101111");
        Assertions.assertTrue(expected1.equals(actual) || expected2.equals(actual));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "112358130",
            "0123",
            "020406",
            "539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511"})
    void splitIntoFibonacci2(String num) {
        Assertions.assertIterableEquals(List.of(), solution.splitIntoFibonacci(num));
    }

}
