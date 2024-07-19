package io.huhu.leetcode.dynamic.programming.hard.n2111;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] arr = {5, 4, 3, 2, 1};
        Assertions.assertEquals(4, solution.kIncreasing(arr, 1));
    }

    @Test
    void test_2() {
        int[] arr = {4, 1, 5, 2, 6, 2};
        Assertions.assertEquals(0, solution.kIncreasing(arr, 2));
    }

    @Test
    void test_3() {
        int[] arr = {4, 1, 5, 2, 6, 2};
        Assertions.assertEquals(2, solution.kIncreasing(arr, 3));
    }

}
