package io.huhu.leetcode.bit.manipulation.easy.n136;

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
    void singleNumber1() {
        int[] nums = {2, 2, 1};
        Assertions.assertEquals(1, solution.singleNumber(nums));
    }

    @Test
    void singleNumber2() {
        int[] nums = {4, 1, 2, 1, 2};
        Assertions.assertEquals(4, solution.singleNumber(nums));
    }

    @Test
    void singleNumber3() {
        int[] nums = {1};
        Assertions.assertEquals(1, solution.singleNumber(nums));
    }

    @Test
    void singleNumber4() {
        int[] nums = {-1};
        Assertions.assertEquals(-1, solution.singleNumber(nums));
    }

}
