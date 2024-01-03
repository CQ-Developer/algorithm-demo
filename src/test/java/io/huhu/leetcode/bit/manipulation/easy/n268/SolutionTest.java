package io.huhu.leetcode.bit.manipulation.easy.n268;

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
    void missingNumber1() {
        int[] nums = {3, 0, 1};
        Assertions.assertEquals(2, solution.missingNumber(nums));
    }

    @Test
    void missingNumber2() {
        int[] nums = {0, 1};
        Assertions.assertEquals(2, solution.missingNumber(nums));
    }

    @Test
    void missingNumber3() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Assertions.assertEquals(8, solution.missingNumber(nums));
    }

    @Test
    void missingNumber4() {
        int[] nums = {0};
        Assertions.assertEquals(1, solution.missingNumber(nums));
    }

}
