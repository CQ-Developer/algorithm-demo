package io.huhu.leetcode.back.trace.n842;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void splitIntoFibonacci1() {
        List<List<Integer>> list = List.of(List.of(11, 0, 11, 11), List.of(110, 1, 111));
        Assertions.assertTrue(list.contains(solution.splitIntoFibonacci("1101111")));
    }

    @Test
    void splitIntoFibonacci2() {
        Assertions.assertIterableEquals(List.of(), solution.splitIntoFibonacci("112358130"));
    }

    @Test
    void splitIntoFibonacci3() {
        Assertions.assertIterableEquals(List.of(), solution.splitIntoFibonacci("0123"));
    }

    @Test
    void splitIntoFibonacci4() {
        Assertions.assertIterableEquals(List.of(), solution.splitIntoFibonacci("020406"));
    }

    @Test
    void splitIntoFibonacci5() {
        Assertions.assertIterableEquals(List.of(), solution.splitIntoFibonacci("539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511"));
    }

}
