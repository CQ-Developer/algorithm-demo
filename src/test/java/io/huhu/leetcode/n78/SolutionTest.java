package io.huhu.leetcode.n78;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void subsets_1() {
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3));
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution.subsets(nums);
    }

    @Test
    void subsets_2() {
        List<List<Integer>> expected = List.of(List.of(), List.of(0));
        int[] nums = {0};
        List<List<Integer>> actual = solution.subsets(nums);
    }

}
