package io.huhu.leetcode.dynamic.programming.hard.n1235;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        Assertions.assertEquals(120, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    void test_2() {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        Assertions.assertEquals(150, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    void test_3() {
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        Assertions.assertEquals(6, solution.jobScheduling(startTime, endTime, profit));
    }

}
