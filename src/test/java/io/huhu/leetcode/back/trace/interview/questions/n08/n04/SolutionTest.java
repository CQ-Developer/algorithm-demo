package io.huhu.leetcode.back.trace.interview.questions.n08.n04;

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
        List<List<Integer>> actual = solution.subsets(nums);
        List<List<Integer>> expected = List.of(List.of(3), List.of(1), List.of(2), List.of(1, 2, 3), List.of(1, 3), List.of(2, 3), List.of(1, 2), List.of());
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> subset : expected) {
            Assertions.assertTrue(actual.contains(subset));
        }
    }

}
