package io.huhu.leetcode.dynamic.programming.medium.n152;

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
    void test_1() {
        int[] nums = {2, 3, -2, 4};
        Assertions.assertEquals(6, solution.maxProduct(nums));
    }

    @Test
    void test_2() {
        int[] nums = {-2, 0, -1};
        Assertions.assertEquals(0, solution.maxProduct(nums));
    }

    @Test
    void test_3() {
        int[] nums = {-2};
        Assertions.assertEquals(-2, solution.maxProduct(nums));
    }

    @Test
    void test_4() {
        int[] nums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        Assertions.assertEquals(1000000000, solution.maxProduct(nums));
    }

}