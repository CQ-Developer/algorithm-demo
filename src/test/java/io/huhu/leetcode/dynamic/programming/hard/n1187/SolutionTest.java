package io.huhu.leetcode.dynamic.programming.hard.n1187;

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
        int[] arr1 = {1, 5, 3, 6, 7}, arr2 = {1, 3, 2, 4};
        Assertions.assertEquals(1, solution.makeArrayIncreasing(arr1, arr2));
    }

    @Test
    void test_2() {
        int[] arr1 = {1, 5, 3, 6, 7}, arr2 = {4, 3, 1};
        Assertions.assertEquals(2, solution.makeArrayIncreasing(arr1, arr2));
    }

    @Test
    void test_3() {
        int[] arr1 = {1, 5, 3, 6, 7}, arr2 = {1, 6, 3, 3};
        Assertions.assertEquals(-1, solution.makeArrayIncreasing(arr1, arr2));
    }

}
