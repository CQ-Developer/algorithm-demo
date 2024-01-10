package io.huhu.leetcode.bit.manipulation.easy.n2932;

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
    void maximumStrongPairXor_1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertEquals(7, solution.maximumStrongPairXor(nums));
    }

    @Test
    void maximumStrongPairXor_2() {
        int[] nums = {10, 100};
        Assertions.assertEquals(0, solution.maximumStrongPairXor(nums));
    }

    @Test
    void maximumStrongPairXor_3() {
        int[] nums = {5, 6, 25, 30};
        Assertions.assertEquals(7, solution.maximumStrongPairXor(nums));
    }

}
