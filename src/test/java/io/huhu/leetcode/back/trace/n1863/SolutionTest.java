package io.huhu.leetcode.back.trace.n1863;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void subsetXORSum1() {
        int[] nums = {1, 3};
        Assertions.assertEquals(6, solution.subsetXORSum(nums));
    }

    @Test
    void subsetXORSum2() {
        int[] nums = {5, 1, 6};
        Assertions.assertEquals(28, solution.subsetXORSum(nums));
    }

}
