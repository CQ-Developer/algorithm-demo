package io.huhu.leetcode.bit.manipulation.easy.n2917;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void findKOr_1() {
        int[] nums = {7, 12, 9, 8, 9, 15};
        Assertions.assertEquals(9, solution.findKOr(nums, 4));
    }

    @Test
    void findKOr_2() {
        int[] nums = {2, 12, 1, 11, 4, 5};
        Assertions.assertEquals(0, solution.findKOr(nums, 6));
    }

    @Test
    void findKOr_3() {
        int[] nums = {10, 8, 5, 9, 11, 6, 8};
        Assertions.assertEquals(15, solution.findKOr(nums, 1));
    }

}
