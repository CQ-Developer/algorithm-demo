package io.huhu.leetcode.binary.search.hard.n719;

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
        int[] nums = {1, 3, 1};
        Assertions.assertEquals(0, solution.smallestDistancePair(nums, 1));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1};
        Assertions.assertEquals(0, solution.smallestDistancePair(nums, 2));
    }

    @Test
    void test3() {
        int[] nums = {1, 6, 1};
        Assertions.assertEquals(5, solution.smallestDistancePair(nums, 3));
    }

}