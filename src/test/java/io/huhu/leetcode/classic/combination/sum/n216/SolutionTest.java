package io.huhu.leetcode.classic.combination.sum.n216;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        List<List<Integer>> actual = solution.combinationSum3(3, 7);
        List<List<Integer>> expected = List.of(List.of(1, 2, 4));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test2() {
        List<List<Integer>> actual = solution.combinationSum3(3, 9);
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 6),
                List.of(1, 3, 5),
                List.of(2, 3, 4));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test3() {
        List<List<Integer>> actual = solution.combinationSum3(4, 1);
        List<List<Integer>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

}
