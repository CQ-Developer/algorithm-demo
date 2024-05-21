package io.huhu.leetcode.dynamic.programming.medium.n198;

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
        int[] nums = {1, 2, 3, 1};
        Assertions.assertEquals(4, solution.rob(nums));
    }

    @Test
    void test_2() {
        int[] nums = {2, 7, 9, 3, 1};
        Assertions.assertEquals(12, solution.rob(nums));
    }

    @Test
    void test_3() {
        int[] nums = {2, 1, 1, 2};
        Assertions.assertEquals(4, solution.rob(nums));
    }

    @Test
    void test_4() {
        int[] nums = {
                114, 117, 207, 117, 235, 82, 90, 67, 143, 146,
                53, 108, 200, 91, 80, 223, 58, 170, 110, 236,
                81, 90, 222, 160, 165, 195, 187, 199, 114, 235,
                197, 187, 69, 129, 64, 214, 228, 78, 188, 67,
                205, 94, 205, 169, 241, 202, 144, 240};
        Assertions.assertEquals(4173, solution.rob(nums));
    }

}
