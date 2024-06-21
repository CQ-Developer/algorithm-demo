package io.huhu.leetcode.dynamic.programming.medium.n413;

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
    void test1() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertEquals(3, solution.numberOfArithmeticSlices(nums));
    }

    @Test
    void test2() {
        int[] nums = {1};
        Assertions.assertEquals(0, solution.numberOfArithmeticSlices(nums));
    }

}
