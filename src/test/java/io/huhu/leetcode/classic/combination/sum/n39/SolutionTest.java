package io.huhu.leetcode.classic.combination.sum.n39;

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
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> actual = solution.combinationSum(candidates, 7);
        List<List<Integer>> expected = List.of(List.of(2, 2, 3), List.of(7));
        Assertions.assertEquals(actual.size(), expected.size());
        for (List<Integer> list : expected) {
            Assertions.assertTrue(actual.contains(list));
        }
    }

    void test2() {
        int[] candidates = {2, 3, 5};
    }

}