package io.huhu.leetcode.dynamic.programming.easy.lcr126;

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
        assertEquals(1, solution.fib(2));
    }

    @Test
    void test_2() {
        assertEquals(2, solution.fib(3));
    }

    @Test
    void test_3() {
        assertEquals(3, solution.fib(4));
    }

    @Test
    void test_4() {
        assertEquals(687995182, solution.fib(100));
    }

    @Test
    void test_5() {
        assertEquals(0, solution.fib(0));
    }

}
