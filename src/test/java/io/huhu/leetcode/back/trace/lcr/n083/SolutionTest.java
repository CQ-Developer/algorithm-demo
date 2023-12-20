package io.huhu.leetcode.back.trace.lcr.n083;

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
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution.permute(nums);
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3), List.of(1, 3, 2),
                List.of(2, 1, 3), List.of(2, 3, 1),
                List.of(3, 1, 2), List.of(3, 2, 1));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        int[] nums = {0, 1};
        List<List<Integer>> actual = solution.permute(nums);
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        int[] nums = {1};
        List<List<Integer>> actual = solution.permute(nums);
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertIterableEquals(expected, actual);
    }

}
