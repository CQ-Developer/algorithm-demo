package io.huhu.leetcode.back.trace.lcr.n081;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = List.of(List.of(7), List.of(2, 2, 3));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combination : expected) {
            Assertions.assertTrue(actual.contains(combination));
        }
    }

    @Test
    void case_2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combination : expected) {
            Assertions.assertTrue(actual.contains(combination));
        }
    }

    @Test
    void case_3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void case_4() {
        int[] candidates = {1};
        int target = 1;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combination : expected) {
            Assertions.assertTrue(actual.contains(combination));
        }
    }

    @Test
    void case_5() {
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = List.of(List.of(1, 1));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combination : expected) {
            Assertions.assertTrue(actual.contains(combination));
        }
    }

}
