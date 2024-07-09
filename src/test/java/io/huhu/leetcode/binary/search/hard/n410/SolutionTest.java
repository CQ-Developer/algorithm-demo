package io.huhu.leetcode.binary.search.hard.n410;

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
        int[] nums = {7, 2, 5, 10, 8};
        Assertions.assertEquals(18, solution.splitArray(nums, 2));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertEquals(9, solution.splitArray(nums, 2));
    }

}
