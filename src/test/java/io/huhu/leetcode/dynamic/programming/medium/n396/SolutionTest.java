package io.huhu.leetcode.dynamic.programming.medium.n396;

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
        int[] nums = {4, 3, 2, 6};
        Assertions.assertEquals(26, solution.maxRotateFunction(nums));
    }

    @Test
    void test2() {
        int[] nums = {100};
        Assertions.assertEquals(0, solution.maxRotateFunction(nums));
    }

}
