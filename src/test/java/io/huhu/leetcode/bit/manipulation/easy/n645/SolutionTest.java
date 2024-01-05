package io.huhu.leetcode.bit.manipulation.easy.n645;

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
    void findErrorNums1() {
        int[] nums = {1, 2, 2, 4};
        int[] actual = solution.findErrorNums(nums);
        int[] expect = {2, 3};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    void findErrorNums2() {
        int[] nums = {1, 1};
        int[] actual = solution.findErrorNums(nums);
        int[] expect = {1, 2};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    void findErrorNums3() {
        int[] nums = {2, 3, 2};
        int[] actual = solution.findErrorNums(nums);
        int[] expect = {2, 1};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    void findErrorNums4() {
        int[] nums = {3, 2, 3, 4, 6, 5};
        int[] actual = solution.findErrorNums(nums);
        int[] expect = {3, 1};
        Assertions.assertArrayEquals(expect, actual);
    }

}
