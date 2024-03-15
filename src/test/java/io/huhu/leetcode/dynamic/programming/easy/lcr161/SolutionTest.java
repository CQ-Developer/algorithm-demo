package io.huhu.leetcode.dynamic.programming.easy.lcr161;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] sales = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution.maxSales(sales));
    }

    @Test
    void test_2() {
        int[] sales = {5, 4, -1, 7, 8};
        assertEquals(23, solution.maxSales(sales));
    }

    @Test
    void test_3() {
        int[] sales = {-1};
        assertEquals(-1, solution.maxSales(sales));
    }

}
