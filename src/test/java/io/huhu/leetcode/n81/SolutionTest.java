package io.huhu.leetcode.n81;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void search1() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        Assertions.assertTrue(solution.search(nums, 0));
    }

    @Test
    void search2() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        Assertions.assertFalse(solution.search(nums, 3));
    }

}
