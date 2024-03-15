package io.huhu.leetcode.dynamic.programming.easy.lcs01;

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
        assertEquals(2, solution.leastMinutes(2));
    }

    @Test
    void test_2() {
        assertEquals(3, solution.leastMinutes(4));
    }

    @Test
    void test_3() {
        assertEquals(4, solution.leastMinutes(6));
    }

    @Test
    void test_4() {
        assertEquals(5, solution.leastMinutes(9));
    }

    @Test
    void test_5() {
        assertEquals(12, solution.leastMinutes(1111));
    }

}
