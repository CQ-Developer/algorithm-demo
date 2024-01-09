package io.huhu.leetcode.bit.manipulation.easy.n1863;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void subsetXORSum_1() {
        int[] nums = {1, 3};
        Assertions.assertEquals(6, solution.subsetXORSum(nums));
    }

    @Test
    void subsetXORSum_2() {
        int[] nums = {5, 1, 6};
        Assertions.assertEquals(28, solution.subsetXORSum(nums));
    }

    @Test
    void subsetXORSum_3() {
        int[] nums = {3, 4, 5, 6, 7, 8};
        Assertions.assertEquals(480, solution.subsetXORSum(nums));
    }

}
